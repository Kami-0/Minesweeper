package ru.kami.minesweeper.view.entity;

import javax.swing.*;
import java.awt.*;

import static ru.kami.minesweeper.view.constant.HighScoreTableConstants.*;

public class HighScoreTableTitleJLabel extends JLabel {
    public HighScoreTableTitleJLabel(String value) {
        super(value, SwingConstants.CENTER);
        setPreferredSize(new Dimension(TITLE_WIDTH, TITLE_HEIGHT));
        setFont(TITLE_FONT);
        setForeground(TITLE_FONT_COLOR);
    }
}
