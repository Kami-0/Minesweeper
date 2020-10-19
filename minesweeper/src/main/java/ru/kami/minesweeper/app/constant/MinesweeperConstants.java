package ru.kami.minesweeper.app.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MinesweeperConstants {

    // при первом запуске дефолтно задаются параметры количество строк и столбцов

    public static final int DEFAULT_ROW_COUNT = 9; // строки
    public static final int DEFAULT_COLUMN_COUNT = 9; // столбцы
    public static final int DEFAULT_MINES_COUNT = 10; // количество мин
}
