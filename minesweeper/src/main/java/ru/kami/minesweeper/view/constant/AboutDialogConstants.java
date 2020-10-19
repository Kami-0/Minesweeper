package ru.kami.minesweeper.view.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.awt.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE) // описание окна об игре, параметры текст
public final class AboutDialogConstants {
    public static final String DIALOG_TITLE = "About game";
    public static final int DIALOG_WIDTH = 300;
    public static final int DIALOG_HEIGHT = 200;

    private static final String FONT_NAME = "TimesRoman";
    private static final int FONT_STYLE = Font.BOLD;
    private static final int FONT_SIZE = 16;
    public static final Font FONT = new Font(FONT_NAME, FONT_STYLE, FONT_SIZE);
}
