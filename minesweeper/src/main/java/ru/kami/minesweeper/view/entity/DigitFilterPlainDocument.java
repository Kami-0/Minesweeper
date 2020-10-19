package ru.kami.minesweeper.view.entity;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import static ru.kami.minesweeper.view.constant.DigitFilterConstants.*;
// todo del
class DigitFilterPlainDocument extends PlainDocument {

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (DIGITS_PATTERN.matcher(str).matches()) {
            StringBuilder currentValue = new StringBuilder(getText(OFFSET, getLength())).insert(offs, str);
            int currentValueNumber = Integer.parseInt(currentValue.toString());
            if (offs == ZERO_OFFSET && getLength() == EMPTY_STRING_SIZE) {
                if (INVALID_FIRST_NUMBERS_PATTERN.matcher(str).matches()) {
                    return;
                }
            }
            if (currentValueNumber <= MAX_NUMBER) {
                super.insertString(offs, str, a);
            }
        }
    }
}