package ru.kami.minesweeper.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class MinesweeperCell {

    // Модель клетки
    private final int row; //строка
    private final int column; // столбец
    @Setter
    private boolean mined = false; // заминирована ли
    @Setter
    private boolean opened = false; // открыта ли
    @Setter
    private boolean empty = false; // пустая ли
    @Setter
    private boolean flag = false; // стоит ли флаг

    MinesweeperCell(int row, int column) { // конструктор клетки
        this.row = row;
        this.column = column;
    }
}
