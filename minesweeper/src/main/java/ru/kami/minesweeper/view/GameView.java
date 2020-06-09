package ru.kami.minesweeper.view;

import ru.kami.minesweeper.api.Result;

public interface GameView {

    void renderLoss();

    void renderVictory(int successRate);

    void renderVictoryWithNewRecord(int successRate);

    void updateCell(int row, int column, String code);

    void updateMinLeftStatus(int status);

    void updateTimerStatus(int status);

    void renderHighScore(Result[] results);
}
