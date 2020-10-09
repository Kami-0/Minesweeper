package ru.kami.minesweeper.controller;

import lombok.AllArgsConstructor;
import ru.kami.minesweeper.model.MinesweeperManager;

/**
 * Контроллер прокидывает вызовы из view в model
 */
@AllArgsConstructor
public class Controller {
    private final MinesweeperManager minesweeperManager;

    public void handleUserClickedOnCellLeftMouseButton(int row, int column) {
        minesweeperManager.openCell(row, column);
    }

    public void handleUserClickedOnCellMouseWheel(int row, int column) {
        minesweeperManager.openAroundCell(row, column);
    }

    public void handleUserClickedOnCellRightMouseButton(int row, int column) {
        minesweeperManager.setFlag(row, column);
    }

    public void handleUserClickedOnCellRMBAndLMB(int row, int column) {
        minesweeperManager.openAroundCell(row, column);
    }

    public void handleUserClickedOnExitMenuItemLeftMouseButton() {
        System.exit(0);
    }

    public void handleUserClickedOnNewGame(int gridWidth, int gridHeight, int totalMines) {
        minesweeperManager.createNewGame(gridWidth, gridHeight, totalMines);
    }

    public void handleUserEnteredOnCell(int row, int column) {
        minesweeperManager.notifyViewEnteredOnCell(row, column, true);
    }

    public void handleUserExitedOnCell(int row, int column) {
        minesweeperManager.notifyViewEnteredOnCell(row, column, false);
    }

    public void handleUserGameRestart() {
        minesweeperManager.createNewGame();
    }

    public void handleUserAddPlayerName(String playerName) {
        minesweeperManager.setPlayerName(playerName);
    }
}