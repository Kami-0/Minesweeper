package ru.kami.minesweeper.view.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DigitFilterConstants {
    public static final Pattern DIGITS_PATTERN = Pattern.compile("\\d+");
    public static final Pattern INVALID_FIRST_NUMBERS_PATTERN = Pattern.compile("[0345]");
    public static final int MAX_NUMBER = 25;
    public static final int OFFSET = 0;
    public static final int ZERO_OFFSET = 0;
    public static final int EMPTY_STRING_SIZE = 0;
}
