package ru.kami.minesweeper.view.entity;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
public class CellView extends JLabel {
    private final int row;
    private final int column;
    @Setter
    private boolean mined;

    public CellView(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
