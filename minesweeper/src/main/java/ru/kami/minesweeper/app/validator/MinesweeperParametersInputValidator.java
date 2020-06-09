package ru.kami.minesweeper.app.validator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MinesweeperParametersInputValidator {
    public static boolean isNotValid(int value) {
        return value <= 0 || value >= 100;
    }
}
