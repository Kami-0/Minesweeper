package ru.kami.minesweeper.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.kami.minesweeper.api.Result;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ResultConverter {
    static String convertToString(Result result) {
        return result.getPlayerName() + " " + result.getRowNumber() + " " + result.getColumnNumber() +
                " " + result.getMines() + " " + result.getSeconds() + " " + result.getSuccessRate() + System.lineSeparator();
    }
}
