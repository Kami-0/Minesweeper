package ru.kami.minesweeper.view.adapter;

import lombok.Getter;
import ru.kami.minesweeper.model.MinesweeperManager;
import ru.kami.minesweeper.view.constant.MouseButtonConstants;
import ru.kami.minesweeper.view.entity.CellView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
 // класс отрабатывающий события связанные с нажатием кнопки мыши
public final class CellMouseAdapter {
    private final MinesweeperManager minesweeperManager;
    private final CellView cellView; // клетка
    @Getter
    private final List<MouseAdapter> cellMouseAdapterList = new ArrayList<>(); // список хранящий возможные события

    public CellMouseAdapter(MinesweeperManager minesweeperManager, CellView cellView) {
        this.minesweeperManager = minesweeperManager;
        this.cellView = cellView;
    }

    {
        cellMouseAdapterList.add(new MouseAdapter() { // метод адд встроенный добавляет элемент в список
            @Override
            // навод мыши на мыши на ячейку
            public void mouseEntered(MouseEvent e) {
                minesweeperManager.notifyViewEnteredOnCell(cellView.getRow(), cellView.getColumn(), true);
                // определяется какая именно ячейка была передана
            }

            @Override

            public void mouseExited(MouseEvent e) {
                minesweeperManager.notifyViewEnteredOnCell(cellView.getRow(), cellView.getColumn(), false);
                // определяется с какой именно ячейки убрали курсор
            }
        });
        cellMouseAdapterList.add(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { // если нажатие на левую клавишу
                if (e.getButton() == MouseButtonConstants.LEFT_MOUSE_BUTTON) {
                    minesweeperManager.openCell(cellView.getRow(), cellView.getColumn());
                    // открывается выбранная клетка при нажатии
                }
            }
        });

        cellMouseAdapterList.add(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // отрабатывает нажатие правой кнопки мыши, устанавливается флажок
                if (e.getButton() == MouseButtonConstants.RIGHT_MOUSE_BUTTON) {
                    minesweeperManager.setFlag(cellView.getRow(), cellView.getColumn());
                }
            }
        });

    }
}
