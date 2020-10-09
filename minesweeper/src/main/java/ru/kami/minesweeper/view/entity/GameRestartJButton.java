package ru.kami.minesweeper.view.entity;

import ru.kami.minesweeper.model.MinesweeperManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameRestartJButton extends JButton {
    private static final String BUTTON_TITLE = "Restart";
    private final MinesweeperManager minesweeperManager;
    private final Frame owner;

    public GameRestartJButton(Frame owner, MinesweeperManager minesweeperManager) {
        super(BUTTON_TITLE);
        this.minesweeperManager = minesweeperManager;
        this.owner = owner;
        setToolTipText("Restarting the current game");
    }

    {
        addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minesweeperManager.createNewGame();
                owner.setVisible(false);
                owner.dispose();
            }
        }));
    }
}