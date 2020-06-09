package ru.kami.minesweeper.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class MinesweeperCell {
    private final int row;
    private final int column;
    @Setter
    private boolean mined = false;
    @Setter
    private boolean opened = false;
    @Setter
    private boolean empty = false;
    @Setter
    private boolean flag = false;

    MinesweeperCell(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
