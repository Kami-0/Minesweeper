package ru.kami.minesweeper.view.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GameNewUIConstants {
    // параметры окна появляющегося после нажатия на "новая игра"
    public static final String DIALOG_TITLE = "New Game";
    public static final int GRID_LAYOUT_ROWS = 3;
    public static final int GRID_LAYOUT_COLUMNS = 2;
    public static final int GRID_LAYOUT_GAP_HEIGHT = 10;
    public static final int GRID_LAYOUT_GAP_WIDTH = 5;
    public static final int DIALOG_WIDTH = 250;
    public static final int DIALOG_HEIGHT = 230;
}
