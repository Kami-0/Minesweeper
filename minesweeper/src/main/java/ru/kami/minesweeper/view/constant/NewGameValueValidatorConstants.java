package ru.kami.minesweeper.view.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NewGameValueValidatorConstants {
    public static final int GRID_MIN_SIZE = 6;
    public static final int GRID_MAX_SIZE = 25;
    public static final int MINES_MIN_NUMBER = 6;
    public static final int MINES_MAX_NUMBER = 99;
}
