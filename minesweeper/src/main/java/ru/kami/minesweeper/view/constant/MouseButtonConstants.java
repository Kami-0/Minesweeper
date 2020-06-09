package ru.kami.minesweeper.view.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.awt.event.MouseEvent;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MouseButtonConstants {
    public static final int LEFT_MOUSE_BUTTON = MouseEvent.BUTTON1;
    public static final int RIGHT_MOUSE_BUTTON = MouseEvent.BUTTON3;
    public static final int MOUSE_WHEEL = MouseEvent.BUTTON2;
}