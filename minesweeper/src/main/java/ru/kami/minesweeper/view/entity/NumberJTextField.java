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

    public void createWarning() {
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.RED, GameNewNumberJTextField.WARNING_EMPTY_BORDER_THICKNESS),
                BorderFactory.createEmptyBorder(
                        GameNewNumberJTextField.WARNING_EMPTY_BORDER_TOP,
                        GameNewNumberJTextField.WARNING_EMPTY_BORDER_LEFT,
                        GameNewNumberJTextField.WARNING_EMPTY_BORDER_BOTTOM,
                        GameNewNumberJTextField.WARNING_EMPTY_BORDER_RIGHT)));
    }

    public void cancelWarning() {
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createBevelBorder(BevelBorder.RAISED),
                BorderFactory.createEmptyBorder(
                        GameNewNumberJTextField.EMPTY_BORDER_TOP,
                        GameNewNumberJTextField.EMPTY_BORDER_LEFT,
                        GameNewNumberJTextField.EMPTY_BORDER_BOTTOM,
                        GameNewNumberJTextField.EMPTY_BORDER_RIGHT)));
    }
}
