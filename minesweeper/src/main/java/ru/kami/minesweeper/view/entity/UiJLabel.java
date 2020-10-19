package ru.kami.minesweeper.view.entity;

import javax.swing.*;
import java.awt.*;

import static ru.kami.minesweeper.view.constant.GlobalConstants.FONT;
import static ru.kami.minesweeper.view.constant.UIConstants.*;

public class UiJLabel extends JLabel {
    public UiJLabel() {
        // отображение чисел возле иконок (мина, таймер)
        super(INITIAL_VALUE, SwingConstants.CENTER);
        setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
        setFont(FONT);
        setForeground(FONT_COLOR);
    }
}
