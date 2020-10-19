package ru.kami.minesweeper.model.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

// параметры таймера ???

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MinesweeperManagerConstants {
   //
    public final static int NOT_VALID_CELL_INDEX = -1;
    //
    public final static int TIMER_DELAY = 1000;
    public final static int TIMER_PERIOD = 1000;
}
