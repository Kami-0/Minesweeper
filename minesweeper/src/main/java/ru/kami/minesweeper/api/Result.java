package ru.kami.minesweeper.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Result {
    private String playerName;
    private int rowNumber;
    private int columnNumber;
    private int mines;
    private int seconds;
    private int successRate;

    public Result(String playerName, int rowNumber, int columnNumber, int mines, int seconds, int successRate) {
        this.playerName = playerName;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.mines = mines;
        this.seconds = seconds;
        this.successRate = successRate;
    }
}
