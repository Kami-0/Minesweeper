package ru.kami.minesweeper.app;

import lombok.extern.slf4j.Slf4j;
import ru.kami.minesweeper.controller.Controller;
import ru.kami.minesweeper.model.MinesweeperManager;
import ru.kami.minesweeper.view.GameView;
import ru.kami.minesweeper.view.SwingViewGame;
import ru.kami.minesweeper.app.constant.MinesweeperConstants;
import ru.kami.minesweeper.app.validator.MinesweeperParametersInputValidator;

@Slf4j
public class Minesweeper {
    public static void main(String[] args) {
        int rowCount;
        int columnCount;
        int minCount;
        if (args.length == MinesweeperConstants.NUMBER_PARAMETERS) {
            try {
                rowCount = Integer.parseInt(args[MinesweeperConstants.ROW_COUNT_INDEX]);
                columnCount = Integer.parseInt(args[MinesweeperConstants.COLUMN_COUNT_INDEX]);
                minCount = Integer.parseInt(args[MinesweeperConstants.MIN_COUNT_INDEX]);
            } catch (NumberFormatException ex) {
                log.error("Некорректные входные параметры ", ex);
                return;
            }
            if (MinesweeperParametersInputValidator.isNotValid(rowCount) || MinesweeperParametersInputValidator.isNotValid(columnCount) || MinesweeperParametersInputValidator.isNotValid(minCount)) {
                return;
            }
        } else {
            rowCount = MinesweeperConstants.DEFAULT_ROW_COUNT;
            columnCount = MinesweeperConstants.DEFAULT_COLUMN_COUNT;
            minCount = MinesweeperConstants.DEFAULT_MINES_COUNT;
        }
        MinesweeperManager minesweeperManager = new MinesweeperManager(rowCount, columnCount, minCount);
        Controller controller = new Controller(minesweeperManager);
        GameView gameView = new SwingViewGame(controller, rowCount, columnCount);
        minesweeperManager.attachView(gameView);
        log.info("Application started..");
    }
}
