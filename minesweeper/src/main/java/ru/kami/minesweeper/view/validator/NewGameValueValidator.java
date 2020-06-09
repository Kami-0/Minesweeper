package ru.kami.minesweeper.view.validator;

import static ru.kami.minesweeper.view.constant.NewGameValueValidatorConstants.*;

public class NewGameValueValidator {
    public boolean isNotValidGridSize(int value) {
        return value < GRID_MIN_SIZE || value > GRID_MAX_SIZE;
    }

    public boolean isValidTotalMines(int gridWidth, int gridHeight, int totalMines) {
        return totalMines >= MINES_MIN_NUMBER && totalMines <= MINES_MAX_NUMBER && gridHeight * gridWidth > totalMines;
    }
}
