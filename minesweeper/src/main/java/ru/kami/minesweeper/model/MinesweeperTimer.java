package ru.kami.minesweeper.model;

import lombok.Getter;

import java.util.TimerTask;

public class MinesweeperTimer extends TimerTask {
    @Getter
    private int seconds;
    private final MinesweeperManager minesweeperManager;

    public MinesweeperTimer(MinesweeperManager minesweeperManager) {
        this.seconds = 0;
        this.minesweeperManager = minesweeperManager;
    }

    @Override
    public void run() {
        this.seconds++;
        minesweeperManager.setSeconds(this.seconds);
        minesweeperManager.setStatusTimer(this.seconds);
    }
}

