package ru.kami.minesweeper.view.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.awt.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GameGridPanelConstants {
    public static final Color BORDER_COLOR = new Color(10, 23, 2);
    public static final String INITIAL_CELL_IMAGE_CODE = "flagOff";

    public static final int ACTIVE_CELL_WIDTH = 30;
    public static final int ACTIVE_CELL_HEIGHT = 30;
    public static final int GAP_WIDTH = 1;
    public static final int GAP_HEIGHT = 1;
    public static final int CELL_WIDTH = ACTIVE_CELL_WIDTH + GAP_WIDTH;
    public static final int CELL_HEIGHT = ACTIVE_CELL_HEIGHT + GAP_HEIGHT;
}
