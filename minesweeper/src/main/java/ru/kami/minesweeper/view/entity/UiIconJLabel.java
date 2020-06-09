package ru.kami.minesweeper.view.entity;

import lombok.extern.slf4j.Slf4j;
import ru.kami.minesweeper.view.icon.MinesweeperImageIconRegistry;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

import static ru.kami.minesweeper.view.constant.UIConstants.ICON_HEIGHT;
import static ru.kami.minesweeper.view.constant.UIConstants.ICON_WIDTH;

@Slf4j
public class UiIconJLabel extends JLabel {
    public UiIconJLabel(String code) {
        setPreferredSize(new Dimension(ICON_WIDTH, ICON_HEIGHT));
        Optional<ImageIcon> imageIcon = MinesweeperImageIconRegistry.getUiImageIconMap(code);
        if (imageIcon.isPresent()) {
            setIcon(imageIcon.get());
        } else {
            log.error("Ошибка в получении иконки c кодом: {}", code);
        }
    }
}
