package ru.kami.minesweeper.view.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.awt.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GlobalConstants {
    private static final String FONT_NAME = "TimesRoman";
    private static final int FONT_STYLE = Font.BOLD;
    private static final int FONT_SIZE = 22;
    public static final Font FONT = new Font(FONT_NAME, FONT_STYLE, FONT_SIZE);
    public static final Color BACKGROUND_COLOR = new Color(18, 43, 4);
}
