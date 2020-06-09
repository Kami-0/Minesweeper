package ru.kami.minesweeper.app.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MinesweeperConstants {
    public static final int NUMBER_PARAMETERS = 3;
    public static final int ROW_COUNT_INDEX = 0;
    public static final int COLUMN_COUNT_INDEX = 1;
    public static final int MIN_COUNT_INDEX = 2;

    public static final int DEFAULT_ROW_COUNT = 9;
    public static final int DEFAULT_COLUMN_COUNT = 9;
    public static final int DEFAULT_MINES_COUNT = 10;
}
