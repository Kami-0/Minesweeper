package ru.kami.minesweeper.view.entity;

import ru.kami.minesweeper.model.MinesweeperManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Кнопка начала новой игры
 */
public class GameNewEnterJButton extends JButton {
    private static final String BUTTON_TITLE = "Run";
    private final MinesweeperManager minesweeperManager;
    private final NumberJTextField width;
    private final NumberJTextField height;
    private final NumberJTextField mines;
    private final Frame owner;

    public GameNewEnterJButton(Frame owner, MinesweeperManager minesweeperManager, NumberJTextField width, NumberJTextField height, NumberJTextField mines) {
        super(BUTTON_TITLE);
        this.minesweeperManager = minesweeperManager;
        this.width = width;
        this.height = height;
        this.mines = mines;
        this.owner = owner;
    }

    {
        addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int gridWidth = Integer.parseInt(width.getText());
                int gridHeight = Integer.parseInt(height.getText());
                int totalMines = Integer.parseInt(mines.getText());
                minesweeperManager.createNewGame(gridWidth, gridHeight, totalMines);
                owner.setVisible(false);
                owner.dispose();
            }
        }
        ));
    }
}
