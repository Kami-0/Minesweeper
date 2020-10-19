package ru.kami.minesweeper.view.adapter;

import ru.kami.minesweeper.view.SwingViewGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MenuMouseAdapter {
    private final Map<String, MouseAdapter> jMenuItemMouseAdapterMap = new HashMap<>();
    private final SwingViewGame game;

    public MenuMouseAdapter(SwingViewGame game) {
        this.game = game;
    } // ссылка на графическую часть

    {

        jMenuItemMouseAdapterMap.put("Exit", new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { // выход из игры
                if (e.getButton() == MouseEvent.BUTTON1) {
                    System.exit(0);
                }
            }
        });
        jMenuItemMouseAdapterMap.put("New Game", new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { // создание новой игры
                if (e.getButton() == MouseEvent.BUTTON1) {
                    game.renderGameNewDialog();
                }
            }
        });
        jMenuItemMouseAdapterMap.put("About", new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { // раздел об игре
                if (e.getButton() == MouseEvent.BUTTON1) {
                    game.renderAboutMenuDialog();
                }
            }
        });
        jMenuItemMouseAdapterMap.put("Rules", new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { // окно с правилами
                if (e.getButton() == MouseEvent.BUTTON1) {
                    game.renderRulesMenuDialog();
                }
            }
        });
    }



    public Optional<MouseAdapter> getMenuMouseAdapterMap(String code) {
        return Optional.ofNullable(jMenuItemMouseAdapterMap.get(code));
    }
}
