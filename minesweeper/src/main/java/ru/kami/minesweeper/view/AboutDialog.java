package ru.kami.minesweeper.view;

import lombok.extern.slf4j.Slf4j;
import ru.kami.minesweeper.view.constant.AboutDialogConstants;

import javax.swing.*;
import java.awt.*;

import static ru.kami.minesweeper.view.constant.AboutDialogConstants.DIALOG_TITLE;
import static ru.kami.minesweeper.view.constant.AboutDialogConstants.FONT;

@Slf4j
class AboutDialog extends JDialog {
    AboutDialog(Frame owner) {
        super(owner, DIALOG_TITLE, true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(AboutDialogConstants.DIALOG_WIDTH, AboutDialogConstants.DIALOG_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(owner);

        JTextArea textField = new JTextArea();
        textField.setText("Made to order by Focus Start in 2020" + System.lineSeparator() +
                "Author: Makarov Daniil (Kami)");
        textField.setEditable(false);
        textField.setFont(FONT);
        add(textField);
        setVisible(false);
    }
}
