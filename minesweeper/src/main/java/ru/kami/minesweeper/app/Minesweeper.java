package ru.kami.minesweeper.app;

import ru.kami.minesweeper.model.MinesweeperManager;
import ru.kami.minesweeper.view.GameView;
import ru.kami.minesweeper.view.SwingViewGame;

import static ru.kami.minesweeper.app.constant.MinesweeperConstants.*;

/**
 * Инициализируем игру
 */
public class Minesweeper {
    public static void main(String[] args) {
        MinesweeperManager minesweeperManager = new MinesweeperManager(DEFAULT_ROW_COUNT, DEFAULT_COLUMN_COUNT, DEFAULT_MINES_COUNT);
        GameView gameView = new SwingViewGame(minesweeperManager, DEFAULT_ROW_COUNT, DEFAULT_COLUMN_COUNT);
        minesweeperManager.attachView(gameView);
    }
}
