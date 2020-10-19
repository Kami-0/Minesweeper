package ru.kami.minesweeper.view.entity;

import ru.kami.minesweeper.view.constant.GameNewNumberJTextField;
import ru.kami.minesweeper.view.constant.GlobalConstants;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class NumberJTextField extends JTextField {
    public NumberJTextField() {
        super.setFont(GlobalConstants.FONT);
        super.setDocument(new DigitFilterPlainDocument());
        super.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createBevelBorder(BevelBorder.RAISED),
                BorderFactory.createEmptyBorder(
                        GameNewNumberJTextField.EMPTY_BORDER_TOP,
                        GameNewNumberJTextField.EMPTY_BORDER_LEFT,
                        GameNewNumberJTextField.EMPTY_BORDER_BOTTOM,
                        GameNewNumberJTextField.EMPTY_BORDER_RIGHT)));
    }
}
