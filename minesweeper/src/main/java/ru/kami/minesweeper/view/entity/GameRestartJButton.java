package ru.kami.minesweeper.view.entity;

import ru.kami.minesweeper.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameRestartJButton extends JButton {
    private static final String BUTTON_TITLE = "Restart";
    private final Controller controller;
    private final Frame owner;

    public GameRestartJButton(Frame owner, Controller controller) {
        super(BUTTON_TITLE);
        this.controller = controller;
        this.owner = owner;
        setToolTipText("Restarting the current game");
    }

    {
        addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleUserGameRestart();
                owner.setVisible(false);
                owner.dispose();
            }
        }));
    }
}