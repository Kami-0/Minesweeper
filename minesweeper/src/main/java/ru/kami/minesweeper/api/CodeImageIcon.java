package ru.kami.minesweeper.api;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CodeImageIcon {
    private final static Map<Integer, String> totalMinMap = new HashMap<>();

    static {
        totalMinMap.put(0, "zero");
        totalMinMap.put(1, "one");
        totalMinMap.put(2, "two");
        totalMinMap.put(3, "three");
        totalMinMap.put(4, "four");
        totalMinMap.put(5, "five");
        totalMinMap.put(6, "six");
        totalMinMap.put(7, "seven");
        totalMinMap.put(8, "eight");
    }

    public static Optional<String> getCodeIcon(int totalMin) {
        return Optional.ofNullable(totalMinMap.get(totalMin));
    }
}
