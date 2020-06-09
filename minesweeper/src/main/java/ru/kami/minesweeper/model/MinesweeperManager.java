package ru.kami.minesweeper.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ru.kami.minesweeper.api.CodeImageIcon;
import ru.kami.minesweeper.api.Result;
import ru.kami.minesweeper.app.Minesweeper;
import ru.kami.minesweeper.model.constant.MinesweeperManagerConstants;
import ru.kami.minesweeper.view.GameView;

import java.util.*;

@Slf4j
public class MinesweeperManager {
    private final int rowNumber;
    private final int columnNumber;
    private final int totalMin;
    private final GameCellsAnalyzer gameCellsAnalyzer;
    private final ViewCellModifier viewCellModifier;
    private final ViewNotifier viewNotifier;
    private final MinesweeperCell[][] minesweeperCells;
    private final HighScoreTable highScoreTable;
    @Setter
    private Timer timer;
    private int closedCell;
    private int minLeft;
    private boolean endGame = false;
    @Setter
    private int seconds = 0;
    @Setter
    private String playerName;

    public MinesweeperManager(int rowNumber, int columnNumber, int totalMin) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.totalMin = totalMin;
        this.gameCellsAnalyzer = new GameCellsAnalyzer();
        this.viewCellModifier = new ViewCellModifier();
        this.viewNotifier = new ViewNotifier();
        this.highScoreTable = new HighScoreTable();
        closedCell = rowNumber * columnNumber;
        minesweeperCells = new MinesweeperCell[rowNumber][columnNumber];
        minLeft = totalMin;
        initializeGameCells();
        initializeMines();
    }

    private void initializeGameCells() {
        log.info("Game cells initialization started. Column number: {} row Number: {} ..", columnNumber, rowNumber);
        for (int i = 0; i < columnNumber; i++) {
            for (int j = 0; j < rowNumber; j++) {
                minesweeperCells[j][i] = new MinesweeperCell(j, i);
            }
        }
        log.info("Game cells initialization ended ..");
    }

    private void initializeMines() {
        log.info("Mines initialization started.Count mines: {} ..", totalMin);
        int mines = totalMin;
        while (mines > 0) {
            Random random = new Random();
            int randomIndexRow = random.nextInt(rowNumber);
            int randomIndexColumn = random.nextInt(columnNumber);
            if (!minesweeperCells[randomIndexRow][randomIndexColumn].isMined()) {
                minesweeperCells[randomIndexRow][randomIndexColumn].setMined(true);
                mines--;
            }
        }
        log.info("Mines initialization ended ..");
    }

    public void createNewGame(int gridWidth, int gridHeight, int totalMines) {
        log.info("Create new game grid width: {} grid height: {} total mines: {}", gridWidth, gridHeight, totalMines);
        String[] args = new String[]{String.valueOf(gridWidth), String.valueOf(gridHeight), String.valueOf(totalMines)};
        Minesweeper.main(args);
    }

    public void createNewGame() {
        log.info("Create new game grid width: {} grid height: {} total mines: {}", columnNumber, rowNumber, totalMin);
        String[] args = new String[]{String.valueOf(columnNumber), String.valueOf(rowNumber), String.valueOf(totalMin)};
        Minesweeper.main(args);
    }

    public void attachView(GameView gameView) {
        viewNotifier.attachView(gameView);
        notifyViewMinLeft();
    }

    public void openCell(int row, int column) {
        int totalCell = rowNumber * columnNumber;
        if (closedCell == totalCell) {
            runTimer();
        }
        if (endGame) {
            return;
        }
        MinesweeperCell cell = minesweeperCells[row][column];
        if (cell.isFlag()) {
            return;
        }
        if (cell.isMined()) {
            viewCellModifier.openTheMinedCell(row, column);
            createGameEnd(row, column, false);
        } else {
            viewCellModifier.openNonMinedCell(row, column);
            if (closedCell == totalMin) {
                createGameEnd(MinesweeperManagerConstants.NOT_VALID_CELL_INDEX, MinesweeperManagerConstants.NOT_VALID_CELL_INDEX, true);
            }
        }
        notifyViewMinLeft();
    }

    private void runTimer() {
        log.info("Timer run..");
        Timer timer = new Timer();
        MinesweeperTimer minesweeperTimer = new MinesweeperTimer(this);
        timer.schedule(minesweeperTimer, MinesweeperManagerConstants.TIMER_DELAY, MinesweeperManagerConstants.TIMER_PERIOD);
        this.timer = timer;
    }

    void setStatusTimer(int status) {
        viewNotifier.notifyViewsNewTimerStatus(status);
    }

    public void openAroundCell(int row, int column) {
        if (endGame || !minesweeperCells[row][column].isOpened()) {
            return;
        }

        int totalMinesAroundForCell = gameCellsAnalyzer.countHowManyMinesAroundCell(row, column);
        int totalFlagsAroundForCell = gameCellsAnalyzer.countHowManyFlagsAroundCell(row, column);
        if (totalFlagsAroundForCell == totalMinesAroundForCell) {
            Map<Integer, Integer> minedMap = viewCellModifier.openAroundUnFlaggedCells(row, column);
            if (minedMap.size() > 0) {
                minedMap.forEach((rowIterator, columnIterator) -> createGameEnd(rowIterator, columnIterator, false));
                return;
            }
        }
        if (gameCellsAnalyzer.isVictory()) {
            createGameEnd(MinesweeperManagerConstants.NOT_VALID_CELL_INDEX, MinesweeperManagerConstants.NOT_VALID_CELL_INDEX, true);
        }
    }

    public void setFlag(int row, int column) {
        MinesweeperCell cell = minesweeperCells[row][column];
        if (endGame || cell.isOpened()) {
            return;
        }

        boolean flagSet = !cell.isFlag();
        cell.setFlag(flagSet);
        viewCellModifier.setFlag(row, column, flagSet);

        minLeft = flagSet ? --minLeft : ++minLeft;
        notifyViewMinLeft();
    }

    private void notifyViewMinLeft() {
        viewNotifier.notifyViewMinLeft(minLeft);
    }

    private void createGameEnd(int row, int column, Boolean win) {
        viewCellModifier.openMines(rowNumber, columnNumber, row, column);
        timer.cancel();
        if (!endGame) {
            endGame = true;
            if (win) {
                createVictory();
            } else {
                createLoss();
            }
        }
    }

    private void createVictory() {
        log.info("Create victory");
        int successRate = highScoreTable.calculateSuccessRate(rowNumber, columnNumber, totalMin, seconds);
        int placeInHighScoreTable = highScoreTable.getPlaceInHighScoreTable(successRate);
        //Метод getPlaceInHighScoreTable() возвращает -1 если результат не попал в таблицу рекордов.
        if (placeInHighScoreTable == -1) {
            viewNotifier.notifyViewsVictory(successRate);
        } else {
            viewNotifier.notifyViewsVictoryWithNewRecord(successRate);
            Result result = new Result(playerName, rowNumber, columnNumber, totalMin, seconds, successRate);
            highScoreTable.updateHighScore(result, placeInHighScoreTable);
        }
    }

    private void createLoss() {
        log.info("Create loss");
        viewNotifier.notifyViewsLoss();
    }

    public void notifyViewHighScoreTable() {
        viewNotifier.notifyViewsHighScore(highScoreTable.getTopFiveResults());
    }

    public void notifyViewEnteredOnCell(int row, int column, boolean status) {
        if (!endGame && !minesweeperCells[row][column].isOpened() && !minesweeperCells[row][column].isFlag()) {
            if (status) {
                viewNotifier.notifyViewNewCellStatus(row, column, "activeClosed");
            } else {
                viewNotifier.notifyViewNewCellStatus(row, column, "flagOff");
            }
        }
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    private final class GameCellsAnalyzer {
        private final int abroadBottomIndex = rowNumber;
        private final int abroadRightIndex = columnNumber;

        boolean isValidCell(int row, int column) {
            return (column != MinesweeperManagerConstants.NOT_VALID_CELL_INDEX && row != MinesweeperManagerConstants.NOT_VALID_CELL_INDEX)
                    && row != abroadBottomIndex && column != abroadRightIndex;
        }

        int countHowManyFlagsAroundCell(int row, int column) {
            int flagsCounterNearCell = 0;
            for (int rowIterator = row - 1; rowIterator <= row + 1; rowIterator++) {
                for (int columnIterator = column - 1; columnIterator <= column + 1; columnIterator++) {
                    if (isValidCell(rowIterator, columnIterator) && minesweeperCells[rowIterator][columnIterator].isFlag()) {
                        flagsCounterNearCell++;
                    }
                }
            }
            return flagsCounterNearCell;
        }

        int countHowManyMinesAroundCell(int row, int column) {
            int minCounterNearCell = 0;
            for (int rowIterator = row - 1; rowIterator <= row + 1; rowIterator++) {
                for (int columnIterator = column - 1; columnIterator <= column + 1; columnIterator++) {
                    if (isValidCell(rowIterator, columnIterator)) {
                        if (minesweeperCells[rowIterator][columnIterator].isMined()) {
                            minCounterNearCell++;
                        }
                    }
                }
            }
            return minCounterNearCell;
        }

        boolean isVictory() {
            return totalMin == closedCell;
        }
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    private class ViewCellModifier {
        void openNonMinedCell(int row, int column) {
            MinesweeperCell cell = minesweeperCells[row][column];
            if (cell.isOpened() || cell.isFlag()) {
                return;
            } else {
                cell.setOpened(true);
                closedCell--;
            }
            log.info("Open cell row: {}, column: {}", row, column);
            int minCounterNearCell = gameCellsAnalyzer.countHowManyMinesAroundCell(row, column);
            if (minCounterNearCell == 0) {
                cell.setEmpty(true);
                openAllNonMinedCellsAround(row, column);
            }
            Optional<String> codeIconOpt = CodeImageIcon.getCodeIcon(minCounterNearCell);
            if (!codeIconOpt.isPresent()) {
                log.error("Не удалось получить иконку c кодом {}", minCounterNearCell);
                return;
            }
            viewNotifier.notifyViewNewCellStatus(row, column, codeIconOpt.get());
        }

        void openTheMinedCell(int row, int column) {
            log.info("Open cell row: {}, column: {}", row, column);
            viewNotifier.notifyViewNewCellStatus(row, column, "bombed");
        }

        Map<Integer, Integer> openAroundUnFlaggedCells(int row, int column) {
            Map<Integer, Integer> minedMap = new HashMap<>();
            for (int rowIterator = row - 1; rowIterator <= row + 1; rowIterator++) {
                for (int columnIterator = column - 1; columnIterator <= column + 1; columnIterator++) {
                    if (gameCellsAnalyzer.isValidCell(rowIterator, columnIterator) && !minesweeperCells[rowIterator][columnIterator].isFlag()) {
                        if (minesweeperCells[rowIterator][columnIterator].isMined()) {
                            openTheMinedCell(rowIterator, columnIterator);
                            minedMap.put(rowIterator, columnIterator);
                        } else {
                            openNonMinedCell(rowIterator, columnIterator);
                        }
                    }
                }
            }
            return minedMap;
        }

        void openAllNonMinedCellsAround(int row, int column) {
            for (int bypassRow = row - 1; bypassRow <= row + 1; bypassRow++) {
                for (int bypassColumn = column - 1; bypassColumn <= column + 1; bypassColumn++) {
                    if ((bypassRow == row && bypassColumn == column) || !gameCellsAnalyzer.isValidCell(bypassRow, bypassColumn)) {
                        continue;
                    }
                    openNonMinedCell(bypassRow, bypassColumn);
                }
            }
        }

        void setFlag(int row, int column, boolean flag) {
            log.info("Flag set row: {} column: {} flag: {}", row, column, flag);
            if (flag) {
                viewNotifier.notifyViewNewCellStatus(row, column, "flagOn");
            } else {
                viewNotifier.notifyViewNewCellStatus(row, column, "flagOff");
            }
        }

        void openMines(int numberRow, int numberColumn, int bombedRow, int bombedColumn) {
            for (int row = 0; row < numberRow; row++) {
                for (int column = 0; column < numberColumn; column++) {
                    if (row == bombedRow && column == bombedColumn) {
                        continue;
                    }
                    if (minesweeperCells[row][column].isMined()) {
                        if (minesweeperCells[row][column].isFlag()) {
                            viewNotifier.notifyViewNewCellStatus(row, column, "noBomb");
                        } else {
                            viewNotifier.notifyViewNewCellStatus(row, column, "bomb");
                        }
                    }
                }
            }
        }
    }

}
