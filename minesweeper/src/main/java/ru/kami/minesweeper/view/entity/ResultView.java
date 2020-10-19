package ru.kami.minesweeper.view.entity;

import ru.kami.minesweeper.api.Result;
import ru.kami.minesweeper.view.constant.GlobalConstants;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
// todo del

public class ResultView extends JPanel {
    private static final int PLAYER_NAME_LABEL_WIDTH = 130;

    private ResultView(String playerName, int rowNumber, int columnNumber, int mines, int seconds, int successRate) {
        setBackground(GlobalConstants.BACKGROUND_COLOR);
        add(new HighScoreTableValueJLabel(playerName, PLAYER_NAME_LABEL_WIDTH));
        add(new HighScoreTableValueJLabel(String.valueOf(rowNumber)));
        add(new HighScoreTableValueJLabel(String.valueOf(columnNumber)));
        add(new HighScoreTableValueJLabel(String.valueOf(mines)));
        add(new HighScoreTableValueJLabel(String.valueOf(seconds)));
        add(new HighScoreTableValueJLabel(String.valueOf(successRate)));
    }

    public static List<ResultView> valueOf(Result[] results) {
        List<ResultView> resultViews = new ArrayList<>();
        for (Result result : results) {
            if (result != null) {
                resultViews.add(new ResultView(
                        result.getPlayerName(),
                        result.getRowNumber(),
                        result.getColumnNumber(),
                        result.getMines(),
                        result.getSeconds(),
                        result.getSuccessRate()));
            }
        }
        return resultViews;
    }
}
