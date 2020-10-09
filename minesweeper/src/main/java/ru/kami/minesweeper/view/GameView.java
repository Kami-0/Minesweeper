package ru.kami.minesweeper.view;

public interface GameView {

    void renderLoss();

    void renderVictory();

    void updateCell(int row, int column, String code);

    void updateMinLeftStatus(int status);

    void updateTimerStatus(int status);
}
