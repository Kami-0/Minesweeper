package ru.kami.minesweeper.view.adapter;

import lombok.Getter;
import ru.kami.minesweeper.controller.Controller;
import ru.kami.minesweeper.view.entity.CellView;
import ru.kami.minesweeper.view.constant.MouseButtonConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public final class CellMouseAdapter {
    private final Controller controller;
    private final CellView cellView;
    @Getter
    private final List<MouseAdapter> cellMouseAdapterList = new ArrayList<>();

    public CellMouseAdapter(Controller controller, CellView cellView) {
        this.controller = controller;
        this.cellView = cellView;
    }

    {
        cellMouseAdapterList.add(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                controller.handleUserEnteredOnCell(cellView.getRow(), cellView.getColumn());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                controller.handleUserExitedOnCell(cellView.getRow(), cellView.getColumn());
            }
        });
        cellMouseAdapterList.add(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseButtonConstants.LEFT_MOUSE_BUTTON) {
                    controller.handleUserClickedOnCellLeftMouseButton(cellView.getRow(), cellView.getColumn());
                }
            }
        });
        cellMouseAdapterList.add(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseButtonConstants.MOUSE_WHEEL) {
                    controller.handleUserClickedOnCellMouseWheel(cellView.getRow(), cellView.getColumn());
                }
            }
        });
        cellMouseAdapterList.add(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseButtonConstants.RIGHT_MOUSE_BUTTON) {
                    controller.handleUserClickedOnCellRightMouseButton(cellView.getRow(), cellView.getColumn());
                }
            }
        });
        cellMouseAdapterList.add(new MouseAdapter() {
            private final List<Integer> pressed = new ArrayList<>();

            @Override
            public void mousePressed(MouseEvent e) {
                pressed.add(e.getButton());
                if (pressed.size() > 1) {
                    if (pressed.get(0) == MouseButtonConstants.LEFT_MOUSE_BUTTON && pressed.get(1) == MouseButtonConstants.MOUSE_WHEEL
                            || pressed.get(0) == MouseButtonConstants.MOUSE_WHEEL && pressed.get(1) == MouseButtonConstants.LEFT_MOUSE_BUTTON) {
                        controller.handleUserClickedOnCellRMBAndLMB(cellView.getRow(), cellView.getColumn());
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pressed.clear();
            }
        });
    }
}
