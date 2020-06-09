package ru.kami.minesweeper.view.icon;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.kami.minesweeper.app.Minesweeper;
import ru.kami.minesweeper.view.GameNewOptions;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MinesweeperImageIconRegistry {
    private static final Map<String, ImageIcon> cellIconMap = new HashMap<>();
    private static final Map<GameNewOptions, ImageIcon> newGameOptionsImageIconMap = new HashMap<>();
    private static final Map<String, ImageIcon> uiImageIconMap = new HashMap<>();
    private static final Image gameImage = Toolkit.getDefaultToolkit().getImage(Minesweeper.class.getResource("/uiImages/gameIcon.png"));

    static {
        cellIconMap.put("flagOff", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/gridPanelImages/closed.jpg")));
        cellIconMap.put("activeClosed", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/gridPanelImages/activeClosed.jpg")));
        cellIconMap.put("bomb", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/gridPanelImages/bomb.jpg")));
        cellIconMap.put("bombed", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/gridPanelImages/bombed.jpg")));
        cellIconMap.put("noBomb", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/gridPanelImages/noBomb.jpg")));
        cellIconMap.put("flagOn", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/gridPanelImages/flagOn.jpg")));
        cellIconMap.put("zero", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/gridPanelImages/zero.jpg")));
        cellIconMap.put("one", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/gridPanelImages/num1.jpg")));
        cellIconMap.put("two", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/gridPanelImages/num2.jpg")));
        cellIconMap.put("three", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/gridPanelImages/num3.jpg")));
        cellIconMap.put("four", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/gridPanelImages/num4.jpg")));
        cellIconMap.put("five", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/gridPanelImages/num5.jpg")));
        cellIconMap.put("six", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/gridPanelImages/num6.jpg")));
        cellIconMap.put("seven", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/gridPanelImages/num7.jpg")));
        cellIconMap.put("eight", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/gridPanelImages/num8.jpg")));

        newGameOptionsImageIconMap.put(
                GameNewOptions.GRID_HEIGHT, new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/menuImages/height.jpg")));
        newGameOptionsImageIconMap.put(
                GameNewOptions.GRID_WIDTH, new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/menuImages/width.jpg")));
        newGameOptionsImageIconMap.put(
                GameNewOptions.MINES, new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/menuImages/min.png")));

        uiImageIconMap.put("minUI", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/uiImages/min.png")));
        uiImageIconMap.put("timerUI", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/uiImages/timer.png")));
        uiImageIconMap.put("lose", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/uiImages/lose.png")));
        uiImageIconMap.put("win", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/uiImages/win.png")));
        uiImageIconMap.put("rules", new ImageIcon(MinesweeperImageIconRegistry.class.getResource("/uiImages/rules.png")));
    }

    public static Optional<ImageIcon> getCellIconMap(String code) {
        return Optional.ofNullable(cellIconMap.get(code));
    }

    public static Optional<ImageIcon> getNewGameOptionsImageIconMap(GameNewOptions code) {
        return Optional.ofNullable(newGameOptionsImageIconMap.get(code));
    }

    public static Optional<ImageIcon> getUiImageIconMap(String code) {
        return Optional.ofNullable(uiImageIconMap.get(code));
    }

    public static Optional<Image> getGameImage() {
        return Optional.ofNullable(gameImage);
    }
}