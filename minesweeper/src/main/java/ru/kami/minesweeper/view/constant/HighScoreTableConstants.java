package ru.kami.minesweeper.view.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.File;
// todo del

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HighScoreTableConstants {
    public static final String TITLE = "High score";

    private static final String VALUE_FONT_NAME = "TimesRoman";
    private static final int VALUE_FONT_STYLE = Font.BOLD;
    private static final int VALUE_FONT_SIZE = 22;
    public static final Font VALUE_FONT = new Font(VALUE_FONT_NAME, VALUE_FONT_STYLE, VALUE_FONT_SIZE);
    public static final Color VALUE_FONT_COLOR = Color.WHITE;
    public static final int TABLE_WIDTH = 85;
    public static final int TABLE_HEIGHT = 25;

    private static final String TITLE_FONT_NAME = "TimesRoman";
    private static final int TITLE_FONT_STYLE = Font.BOLD;
    private static final int TITLE_FONT_SIZE = 16;
    public static final Font TITLE_FONT = new Font(TITLE_FONT_NAME, TITLE_FONT_STYLE, TITLE_FONT_SIZE);
    public static final Color TITLE_FONT_COLOR = Color.YELLOW;

    public static final int TITLE_WIDTH = 85;
    public static final int TITLE_HEIGHT = 25;

    public static final int INDEX_ROW_NUMBER = 0;
    public static final int INDEX_COLUMN_NUMBER = 1;
    public static final int INDEX_MINES = 2;
    public static final int INDEX_SECONDS = 3;
    public static final int INDEX_SUCCESS_RATE = 4;
    public static final int MAXIMUM_PLACE = 5;
    public static final int MINIMUM_PLACE = 1;
    public static final int NOT_VALID_PLACE = -1;
    public static final int DECREMENT = 1;
    public static final int INCREMENT = 1;
    public static final int ZERO = 0;
    public static final int MIN_VALUE_SECONDS = 1;
    public static final int COEFFICIENT = 1000;
    public static final File HIGH_SCORE_FILE = new File("./highScore.txt");
}
