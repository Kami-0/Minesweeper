package ru.kami.minesweeper.view;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;

import static ru.kami.minesweeper.view.constant.AboutDialogConstants.*;

@Slf4j
class AboutDialog extends JDialog {
    AboutDialog(Frame owner) {
        super(owner, DIALOG_TITLE, true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(owner);

        JTextArea textField = new JTextArea();
        textField.setText("Author: Nikita Yankov");
        textField.setEditable(false);
        textField.setFont(FONT);
        add(textField);
        setVisible(false);
    }
}
