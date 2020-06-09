package ru.kami.minesweeper.view;

import lombok.extern.slf4j.Slf4j;
import ru.kami.minesweeper.view.icon.MinesweeperImageIconRegistry;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

@Slf4j
class RulesDialog extends JDialog {
    private static final String DIALOG_TITLE = "Rules";
    private static final String RULES_DIALOG_ICON_CODE = "rules";

    public RulesDialog(Frame owner) {
        super(owner, DIALOG_TITLE, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(owner);
        setResizable(false);

        JLabel image = new JLabel();
        Optional<ImageIcon> imageIconOptional = MinesweeperImageIconRegistry.getUiImageIconMap(RULES_DIALOG_ICON_CODE);
        if (imageIconOptional.isPresent()) {
            image.setIcon(imageIconOptional.get());
        } else {
            log.error("Ошибка в получении иконки c кодом: {}", RULES_DIALOG_ICON_CODE);
        }
        add(image);
        pack();
        setVisible(false);
    }
}
