package ru.kami.minesweeper.view;

import ru.kami.minesweeper.model.MinesweeperManager;
import ru.kami.minesweeper.view.adapter.CellMouseAdapter;
import ru.kami.minesweeper.view.adapter.MenuMouseAdapter;
import ru.kami.minesweeper.view.constant.GlobalConstants;
import ru.kami.minesweeper.view.constant.UIConstants;
import ru.kami.minesweeper.view.entity.CellView;
import ru.kami.minesweeper.view.entity.GameRestartJButton;
import ru.kami.minesweeper.view.entity.UiIconJLabel;
import ru.kami.minesweeper.view.entity.UiJLabel;
import ru.kami.minesweeper.view.icon.MinesweeperImageIconRegistry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.awt.GridBagConstraints.WEST;
import static ru.kami.minesweeper.view.constant.GameGridPanelConstants.*;

public class SwingViewGame extends JFrame implements GameView {
    private final CellView[][] cellViews;
    private final MinesweeperManager minesweeperManager;
    private final int rowNumber;
    private final int columnNumber;
    private final JPanel container;
    private final UiJLabel minCounter;
    private final UiJLabel timer;
    private final AboutDialog aboutDialog;
    private final GameNewDialog gameNewDialog;
    private final RulesDialog rulesDialog;

    public SwingViewGame(MinesweeperManager minesweeperManager, int rowNumber, int columnNumber) {
        super(UIConstants.APP_NAME);
        this.minesweeperManager = minesweeperManager;
        this.cellViews = new CellView[rowNumber][columnNumber];
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.container = new JPanel(new GridBagLayout());
        this.minCounter = new UiJLabel();
        this.timer = new UiJLabel();
        this.aboutDialog = new AboutDialog(this);
        this.gameNewDialog = new GameNewDialog(this, minesweeperManager);
        this.rulesDialog = new RulesDialog(this);

        packInFrameContainer();
    }

    private void packInFrameContainer() {
        JPanel gameGridPanel = renderGameGridPanel();
        UiIconJLabel timerUiIconJLabel = new UiIconJLabel(UIConstants.TIMER_ICON_CODE);
        UiIconJLabel minUiIconJLabel = new UiIconJLabel(UIConstants.MIN_ICON_CODE);
        GameRestartJButton gameRestartJButton = new GameRestartJButton(this, minesweeperManager);

        container.add(gameGridPanel, getContainerGridBagConstrains(UIConstants.GAME_GRID_X, UIConstants.GAME_GRID_Y, UIConstants.GAME_GRID_WIDTH, UIConstants.GAME_GRID_HEIGHT));
        container.add(minUiIconJLabel, getContainerGridBagConstrains(UIConstants.MIN_ICON_GRID_X, UIConstants.MIN_ICON_GRID_Y, UIConstants.MIN_ICON_GRID_WIDTH, UIConstants.MIN_ICON_GRID_HEIGHT));
        container.add(minCounter, getContainerGridBagConstrains(UIConstants.MIN_COUNTER_GRID_X, UIConstants.MIN_COUNTER_GRID_Y, UIConstants.MIN_COUNTER_GRID_WIDTH, UIConstants.MIN_COUNTER_GRID_HEIGHT));
        container.add(timerUiIconJLabel, getContainerGridBagConstrains(UIConstants.TIMER_ICON_GRID_X, UIConstants.TIMER_ICON_GRID_Y, UIConstants.TIMER_ICON_GRID_WIDTH, UIConstants.TIMER_ICON_GRID_HEIGHT));
        container.add(timer, getContainerGridBagConstrains(UIConstants.TIMER_GRID_X, UIConstants.TIMER_GRID_Y, UIConstants.TIMER_GRID_WIDTH, UIConstants.TIMER_GRID_HEIGHT));
        container.add(gameRestartJButton, getContainerGridBagConstrains(UIConstants.BUTTON_GRID_X, UIConstants.BUTTON_GRID_Y, UIConstants.BUTTON_GRID_WIDTH, UIConstants.BUTTON_GRID_HEIGHT));

        renderFrame();
        renderMenuBar();
        container.setBackground(GlobalConstants.BACKGROUND_COLOR);
        add(container);

        pack();
    }

    private GridBagConstraints getContainerGridBagConstrains(int gridX, int gridY, int gridWidth, int gridHeight) {
        return new GridBagConstraints(gridX, gridY, gridWidth, gridHeight,
                UIConstants.WEIGHT_X, UIConstants.WEIGHT_Y, WEST, WEST,
                new Insets(UIConstants.INSETS_TOP, UIConstants.INSETS_LEFT, UIConstants.INSETS_BOTTOM, UIConstants.INSETS_RIGHT),
                UIConstants.IPAD_X, UIConstants.IPAD_Y);
    }

    private JPanel renderGameGridPanel() {
        JPanel panelMinefield = new JPanel(new GridLayout(rowNumber, columnNumber, GAP_WIDTH, GAP_HEIGHT));
        panelMinefield.setBackground(GlobalConstants.BACKGROUND_COLOR);

        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < columnNumber; j++) {
                CellView cellView = new CellView(i, j);
                cellView.setOpaque(true);
                cellView.setPreferredSize(new Dimension(ACTIVE_CELL_WIDTH, ACTIVE_CELL_HEIGHT));

                Optional<ImageIcon> imageIconOptional = MinesweeperImageIconRegistry.getCellIconMap(INITIAL_CELL_IMAGE_CODE);
                cellView.setIcon(imageIconOptional.get());

                CellMouseAdapter cellMouseAdapter = new CellMouseAdapter(minesweeperManager, cellView);
                List<MouseAdapter> mouseAdapterList = cellMouseAdapter.getCellMouseAdapterList();
                mouseAdapterList.forEach(cellView::addMouseListener);

                panelMinefield.add(cellView);
                cellViews[i][j] = cellView;
            }
        }

        JPanel minefieldWrapper = new JPanel();
        int minefieldWrapperWidth = rowNumber * CELL_HEIGHT;
        int minefieldWrapperHeight = columnNumber * CELL_WIDTH;
        minefieldWrapper.setSize(minefieldWrapperWidth, minefieldWrapperHeight);
        minefieldWrapper.add(panelMinefield);
        minefieldWrapper.setBackground(BORDER_COLOR);
        add(minefieldWrapper);
        return minefieldWrapper;
    }

    private void renderFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(UIConstants.LOCATION_X, UIConstants.LOCATION_Y);
        Optional<Image> imageOptional = MinesweeperImageIconRegistry.getGameImage();
        setIconImage(imageOptional.get());
        setVisible(true);
    }

    private void renderMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);

        JMenu gameMenu = new JMenu("Game");
        jMenuBar.add(gameMenu);

        List<JMenuItem> menuItemList = new ArrayList<>();
        menuItemList.add(new JMenuItem("New Game"));
        menuItemList.add(new JMenuItem("Exit"));
        menuItemList.forEach(item -> {
            setMouseAdapterToJMenu(item, item.getText());
            gameMenu.add(item);
        });

        JMenu rulesMenu = new JMenu("Rules");
        JMenu aboutMenu = new JMenu("About");
        setMouseAdapterToJMenu(rulesMenu, aboutMenu.getText());
        setMouseAdapterToJMenu(aboutMenu, aboutMenu.getText());
        jMenuBar.add(rulesMenu);
        jMenuBar.add(aboutMenu);
    }

    private void setMouseAdapterToJMenu(JMenuItem jMenuItem, String code) {
        MenuMouseAdapter menuMouseAdapter = new MenuMouseAdapter(this);
        Optional<MouseAdapter> mouseAdapterOptional = menuMouseAdapter.getMenuMouseAdapterMap(jMenuItem.getText());
        jMenuItem.addMouseListener(mouseAdapterOptional.get());
    }

    public void renderGameNewDialog() {
        gameNewDialog.setVisible(true);
    }

    public void renderAboutMenuDialog() {
        aboutDialog.setVisible(true);
    }

    public void renderRulesMenuDialog() {
        rulesDialog.setVisible(true);
    }

    @Override
    public void updateMinLeftStatus(int status) {
        minCounter.setText(String.valueOf(status));
    }

    @Override
    public void updateTimerStatus(int status) {
        timer.setText(String.valueOf(status));
    }

    @Override
    public void renderLoss() {
        new GameEndLoseDialog(this);
    }

    @Override
    public void renderVictory() {
        new GameEndVictoryDialog(this);
    }

    @Override
    public void updateCell(int row, int column, String code) {
        cellViews[row][column].setIcon(MinesweeperImageIconRegistry.getCellIconMap(code).get());
    }

}
