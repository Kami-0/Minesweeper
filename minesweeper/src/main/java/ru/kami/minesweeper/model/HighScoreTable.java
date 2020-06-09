package ru.kami.minesweeper.model;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ru.kami.minesweeper.api.Result;
import ru.kami.minesweeper.model.security.AesCipher;
import ru.kami.minesweeper.view.constant.HighScoreTableConstants;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.Scanner;

@Slf4j
class HighScoreTable {
    @Getter
    private final Result[] topFiveResults = new Result[HighScoreTableConstants.MAXIMUM_PLACE];
    private final AesCipher aesCipher = new AesCipher();

    HighScoreTable() {
        readFile();
    }

    int getPlaceInHighScoreTable(int successRate) {
        for (int i = 0; i < HighScoreTableConstants.MAXIMUM_PLACE; i++) {
            Result currentResult = topFiveResults[i];
            if (currentResult == null || currentResult.getSuccessRate() < successRate) {
                return i + HighScoreTableConstants.INCREMENT;
            }
        }
        return HighScoreTableConstants.NOT_VALID_PLACE;
    }

    void updateHighScore(Result result, int place) {
        if (place > HighScoreTableConstants.MAXIMUM_PLACE || place < HighScoreTableConstants.MINIMUM_PLACE) {
            return;
        }
        Result newResult = result;
        for (int i = place - HighScoreTableConstants.DECREMENT; i < HighScoreTableConstants.MAXIMUM_PLACE; i++) {
            Result currentResult = topFiveResults[i];
            topFiveResults[i] = newResult;
            newResult = currentResult;
        }
        writeInFile();
    }

    int calculateSuccessRate(int rowNumber, int columnNumber, int mines, int seconds) {
        if (seconds == HighScoreTableConstants.ZERO) {
            seconds = HighScoreTableConstants.MIN_VALUE_SECONDS;
        }
        double value = mines * mines / (rowNumber * columnNumber * seconds * 1.0);
        return (int) (value * HighScoreTableConstants.COEFFICIENT);
    }

    private void readFile() {
        try {
            byte[] buffer = Files.readAllBytes(HighScoreTableConstants.HIGH_SCORE_FILE.toPath());
            String decryptedResults = aesCipher.decrypt(buffer);
            Scanner scanner = new Scanner(decryptedResults);
            while (scanner.hasNextLine()) {
                Optional<Result> resultOptional = parseLine(scanner.nextLine());
                resultOptional.ifPresent(this::addResult);
            }
        } catch (IOException e) {
            log.error("Нe удалось открыть файл {}", HighScoreTableConstants.HIGH_SCORE_FILE, e);
        }
    }

    private Optional<Result> parseLine(String line) {
        Result result = new Result();
        Scanner scanner = new Scanner(line);
        String playerName;
        if (scanner.hasNext()) {
            playerName = scanner.next();
        } else {
            return Optional.empty();
        }
        int[] parameters = new int[HighScoreTableConstants.MAXIMUM_PLACE];
        for (int i = 0; i < HighScoreTableConstants.MAXIMUM_PLACE; i++) {
            if (scanner.hasNextInt()) {
                parameters[i] = scanner.nextInt();
            } else {
                return Optional.empty();
            }
        }
        result.setPlayerName(playerName);
        result.setRowNumber(parameters[HighScoreTableConstants.INDEX_ROW_NUMBER]);
        result.setColumnNumber(parameters[HighScoreTableConstants.INDEX_COLUMN_NUMBER]);
        result.setMines(parameters[HighScoreTableConstants.INDEX_MINES]);
        result.setSeconds(parameters[HighScoreTableConstants.INDEX_SECONDS]);
        result.setSuccessRate(parameters[HighScoreTableConstants.INDEX_SUCCESS_RATE]);
        return Optional.of(result);
    }

    private void addResult(Result result) {
        for (int i = 0; i < topFiveResults.length; i++) {
            if (topFiveResults[i] == null) {
                topFiveResults[i] = result;
                break;
            }
        }
    }

    private void writeInFile() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(HighScoreTableConstants.HIGH_SCORE_FILE)) {
            StringBuilder results = new StringBuilder();
            for (Result result : topFiveResults) {
                if (result != null) {
                    results.append(ResultConverter.convertToString(result));
                }
            }
            byte[] encryptedResults = aesCipher.encrypt(results.toString());
            fileOutputStream.write(encryptedResults);
        } catch (IOException e) {
            log.error("Не удалось открыть файл {}", HighScoreTableConstants.HIGH_SCORE_FILE, e);
        }
    }
}
