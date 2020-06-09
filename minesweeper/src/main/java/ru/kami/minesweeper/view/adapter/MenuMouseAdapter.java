package ru.kami.minesweeper.view.adapter;

import ru.kami.minesweeper.controller.Controller;
import ru.kami.minesweeper.view.SwingViewGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MenuMouseAdapter {
    private final Map<String, MouseAdapter> jMenuItemMouseAdapterMap = new HashMap<>();
    private final Controller controller;
    private final SwingViewGame game;

    public MenuMouseAdapter(Controller controller, SwingViewGame game) {
        this.controller = controller;
        this.game = game;
    }

    {
        jMenuItemMouseAdapterMap.put("Exit", new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    controller.handleUserClickedOnExitMenuItemLeftMouseButton();
                }
            }
        });
        jMenuItemMouseAdapterMap.put("New Game", new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    game.renderGameNewDialog();
                }
            }
        });
        jMenuItemMouseAdapterMap.put("About", new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    game.renderAboutMenuDialog();
                }
            }
        });
        jMenuItemMouseAdapterMap.put("Rules", new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    game.renderRulesMenuDialog();
                }
            }
        });
        jMenuItemMouseAdapterMap.put("High Scores", new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    game.requestHighScore();
                }
            }
        });
    }

    public Optional<MouseAdapter> getMenuMouseAdapterMap(String code) {
        return Optional.ofNullable(jMenuItemMouseAdapterMap.get(code));
    }
}
