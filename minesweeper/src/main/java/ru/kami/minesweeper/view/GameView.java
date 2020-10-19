package ru.kami.minesweeper.view;

public interface GameView {

    void renderLoss(); // отобразить проигрыш

    void renderVictory(); // победу

    void updateCell(int row, int column, String code); // обновить клетку после нажатия

    void updateMinLeftStatus(int status); // обновить количество мин

    void updateTimerStatus(int status); // обновить таймер
}
