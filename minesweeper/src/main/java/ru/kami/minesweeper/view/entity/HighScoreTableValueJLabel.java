package ru.kami.minesweeper.view.entity;

import ru.kami.minesweeper.view.constant.HighScoreTableConstants;

import javax.swing.*;
import java.awt.*;

class HighScoreTableValueJLabel extends JLabel {

    public HighScoreTableValueJLabel(String value) {
        super(value, SwingConstants.CENTER);
        setPreferredSize(new Dimension(HighScoreTableConstants.TABLE_WIDTH, HighScoreTableConstants.TABLE_HEIGHT));
        setFont(HighScoreTableConstants.VALUE_FONT);
        setForeground(HighScoreTableConstants.VALUE_FONT_COLOR);
    }

    public HighScoreTableValueJLabel(String value, int width) {
        super(value, SwingConstants.CENTER);
        setPreferredSize(new Dimension(width, HighScoreTableConstants.TABLE_HEIGHT));
        setFont(HighScoreTableConstants.VALUE_FONT);
        setForeground(HighScoreTableConstants.VALUE_FONT_COLOR);
    }
}
