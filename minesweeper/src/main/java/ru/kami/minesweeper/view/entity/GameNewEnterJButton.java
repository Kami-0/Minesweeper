package ru.kami.minesweeper.view.entity;

import ru.kami.minesweeper.controller.Controller;
import ru.kami.minesweeper.view.validator.NewGameValueValidator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameNewEnterJButton extends JButton {
    private static final String BUTTON_TITLE = "Run";
    private final Controller controller;
    private final NumberJTextField width;
    private final NumberJTextField height;
    private final NumberJTextField mines;
    private final Frame owner;

    public GameNewEnterJButton(Frame owner, Controller controller, NumberJTextField width, NumberJTextField height, NumberJTextField mines) {
        super(BUTTON_TITLE);
        this.controller = controller;
        this.width = width;
        this.height = height;
        this.mines = mines;
        this.owner = owner;
        setToolTipText("Field size 6-25 Mines 6-25");
    }

    {
        addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!width.getText().isEmpty() && !height.getText().isEmpty() && !mines.getText().isEmpty()) {
                    int gridWidth = Integer.parseInt(width.getText());
                    int gridHeight = Integer.parseInt(height.getText());
                    int totalMines = Integer.parseInt(mines.getText());
                    NewGameValueValidator validator = new NewGameValueValidator();
                    if (validator.isNotValidGridSize(gridWidth)) {
                        width.createWarning();
                        return;
                    } else {
                        width.cancelWarning();
                    }
                    if (validator.isNotValidGridSize(gridHeight)) {
                        height.createWarning();
                        return;
                    } else {
                        height.cancelWarning();
                    }
                    if (!validator.isValidTotalMines(gridWidth, gridHeight, totalMines)) {
                        mines.createWarning();
                        return;
                    } else {
                        mines.cancelWarning();
                    }
                    controller.handleUserClickedOnNewGame(gridWidth, gridHeight, totalMines);
                    owner.setVisible(false);
                    owner.dispose();
                }
            }
        }));
    }
}
