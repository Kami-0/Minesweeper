package ru.kami.minesweeper.view;

import lombok.extern.slf4j.Slf4j;
import ru.kami.minesweeper.view.icon.MinesweeperImageIconRegistry;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

import static ru.kami.minesweeper.view.constant.GameEndDialogConstants.LOSE_DIALOG_ICON_CODE;
import static ru.kami.minesweeper.view.constant.GameEndDialogConstants.LOSE_DIALOG_TITLE;

@Slf4j
class GameEndLoseDialog extends JDialog {
    GameEndLoseDialog(Frame owner) {
        super(owner, LOSE_DIALOG_TITLE, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        setLocationRelativeTo(owner);
        JLabel wrapper = new JLabel();
        Optional<ImageIcon> imageIconOptional = MinesweeperImageIconRegistry.getUiImageIconMap(LOSE_DIALOG_ICON_CODE);
        if (imageIconOptional.isPresent()) {
            wrapper.setIcon(imageIconOptional.get());
        } else {
            log.error("Ошибка в получении иконки c кодом: lose");
        }
        add(wrapper);
        pack();
        setVisible(true);
    }
}
