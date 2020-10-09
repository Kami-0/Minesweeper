package ru.kami.minesweeper.view;

import lombok.extern.slf4j.Slf4j;
import ru.kami.minesweeper.view.icon.MinesweeperImageIconRegistry;
import ru.kami.minesweeper.view.constant.GameEndDialogConstants;
import ru.kami.minesweeper.view.constant.GlobalConstants;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

import static javax.swing.BoxLayout.Y_AXIS;

@Slf4j
class GameEndVictoryDialog extends JDialog {
    GameEndVictoryDialog(Frame owner) {
        super(owner, GameEndDialogConstants.WIN_DIALOG_TITLE, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        setLocationRelativeTo(owner);
        JLabel image = new JLabel();
        Optional<ImageIcon> imageIconOptional = MinesweeperImageIconRegistry.getUiImageIconMap(GameEndDialogConstants.WIN_DIALOG_ICON_CODE);
        if (imageIconOptional.isPresent()) {
            image.setIcon(imageIconOptional.get());
        } else {
            log.error("Ошибка в получении иконки c кодом: {}", GameEndDialogConstants.WIN_DIALOG_ICON_CODE);
        }
        JLabel result = new JLabel();
        result.setFont(GlobalConstants.FONT);
        result.setForeground(Color.YELLOW);
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, Y_AXIS));
        wrapper.setBackground(GlobalConstants.BACKGROUND_COLOR);
        wrapper.add(image);
        wrapper.add(result);
        add(wrapper);
        pack();
        setVisible(true);
    }
}
