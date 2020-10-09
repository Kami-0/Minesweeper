package ru.kami.minesweeper.view.adapter;

import lombok.Getter;
import ru.kami.minesweeper.model.MinesweeperManager;
import ru.kami.minesweeper.view.constant.MouseButtonConstants;
import ru.kami.minesweeper.view.entity.CellView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public final class CellMouseAdapter {
    private final MinesweeperManager minesweeperManager;
    private final CellView cellView;
    @Getter
    private final List<MouseAdapter> cellMouseAdapterList = new ArrayList<>();

    public CellMouseAdapter(MinesweeperManager minesweeperManager, CellView cellView) {
        this.minesweeperManager = minesweeperManager;
        this.cellView = cellView;
    }

    {
        cellMouseAdapterList.add(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                minesweeperManager.notifyViewEnteredOnCell(cellView.getRow(), cellView.getColumn(), true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                minesweeperManager.notifyViewEnteredOnCell(cellView.getRow(), cellView.getColumn(), false);
            }
        });
        cellMouseAdapterList.add(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseButtonConstants.LEFT_MOUSE_BUTTON) {
                    minesweeperManager.openCell(cellView.getRow(), cellView.getColumn());
                }
            }
        });
        cellMouseAdapterList.add(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseButtonConstants.MOUSE_WHEEL) {
                    minesweeperManager.openAroundCell(cellView.getRow(), cellView.getColumn());
                }
            }
        });
        cellMouseAdapterList.add(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseButtonConstants.RIGHT_MOUSE_BUTTON) {
                    minesweeperManager.setFlag(cellView.getRow(), cellView.getColumn());
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
                        minesweeperManager.openAroundCell(cellView.getRow(), cellView.getColumn());
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
