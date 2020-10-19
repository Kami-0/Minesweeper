package ru.kami.minesweeper.view.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.awt.event.MouseEvent;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MouseButtonConstants {
    public static final int LEFT_MOUSE_BUTTON = MouseEvent.BUTTON1; // переименновываем для удобства понимания
    public static final int RIGHT_MOUSE_BUTTON = MouseEvent.BUTTON3;
}