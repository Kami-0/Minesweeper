package ru.kami.minesweeper.view.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.awt.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UIConstants {
    public static final String APP_NAME = "Minesweeper";
    public static final String MIN_ICON_CODE = "minUI";

    public static final int LOCATION_X;
    public static final int LOCATION_Y;

    static {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        LOCATION_X = dimension.width / 2 - 250;
        LOCATION_Y = dimension.height / 2 - 250;
    }
    public static final Color FONT_COLOR = Color.WHITE;
    public static final int LABEL_WIDTH = 50;
    public static final int LABEL_HEIGHT = 50;
    public static final String INITIAL_VALUE = "0";

    public static final String TIMER_ICON_CODE = "timerUI";
    public static final int ICON_WIDTH = 50;
    public static final int ICON_HEIGHT = 50;

    public static final int WEIGHT_X = 0;
    public static final int WEIGHT_Y = 0;
    public static final int INSETS_TOP = 2;
    public static final int INSETS_BOTTOM = 2;
    public static final int INSETS_LEFT = 2;
    public static final int INSETS_RIGHT = 2;
    public static final int IPAD_X = 0;
    public static final int IPAD_Y = 0;

    public static final int GAME_GRID_X = 0;
    public static final int GAME_GRID_Y = 0;
    public static final int GAME_GRID_WIDTH = 5;
    public static final int GAME_GRID_HEIGHT = 4;

    public static final int MIN_ICON_GRID_X = 0;
    public static final int MIN_ICON_GRID_Y = 4;
    public static final int MIN_ICON_GRID_WIDTH = 1;
    public static final int MIN_ICON_GRID_HEIGHT = 1;

    public static final int MIN_COUNTER_GRID_X = 1;
    public static final int MIN_COUNTER_GRID_Y = 4;
    public static final int MIN_COUNTER_GRID_WIDTH = 1;
    public static final int MIN_COUNTER_GRID_HEIGHT = 1;

    public static final int TIMER_ICON_GRID_X = 2;
    public static final int TIMER_ICON_GRID_Y = 4;
    public static final int TIMER_ICON_GRID_WIDTH = 1;
    public static final int TIMER_ICON_GRID_HEIGHT = 1;

    public static final int TIMER_GRID_X = 3;
    public static final int TIMER_GRID_Y = 4;
    public static final int TIMER_GRID_WIDTH = 1;
    public static final int TIMER_GRID_HEIGHT = 1;

    public static final int BUTTON_GRID_X = 4;
    public static final int BUTTON_GRID_Y = 4;
    public static final int BUTTON_GRID_WIDTH = 1;
    public static final int BUTTON_GRID_HEIGHT = 1;
}
