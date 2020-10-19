package ru.kami.minesweeper.model;

import lombok.Getter;

import java.util.TimerTask;

public class MinesweeperTimer extends TimerTask { // таймер игры наследованный от класса таймертаск
    @Getter
    private int seconds;
    private final MinesweeperManager minesweeperManager; // ссылка на главный класс чтобы отдать ему значения

    public MinesweeperTimer(MinesweeperManager minesweeperManager) {
        this.seconds = 0;
        this.minesweeperManager = minesweeperManager; // изначально задаем что таймер идет с нуля
    }

    @Override
    public void run() {
        this.seconds++;
        minesweeperManager.setSeconds(this.seconds);
        minesweeperManager.setStatusTimer(this.seconds);
    }
}

