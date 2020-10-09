package ru.kami.minesweeper.view;

import ru.kami.minesweeper.view.constant.GameEndDialogConstants;
import ru.kami.minesweeper.view.constant.GlobalConstants;
import ru.kami.minesweeper.view.icon.MinesweeperImageIconRegistry;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

import static javax.swing.BoxLayout.Y_AXIS;

class GameEndVictoryDialog extends JDialog {
    GameEndVictoryDialog(Frame owner) {
        super(owner, GameEndDialogConstants.WIN_DIALOG_TITLE, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        setLocationRelativeTo(owner);
        JLabel image = new JLabel();
        Optional<ImageIcon> imageIconOptional = MinesweeperImageIconRegistry.getUiImageIconMap(GameEndDialogConstants.WIN_DIALOG_ICON_CODE);
        image.setIcon(imageIconOptional.get());
        JLabel result = new JLabel();
        result.setFont(GlobalConstants.FONT);
        result.setForeground(Color.YELLOW);
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, Y_AXIS));
        wrapper.setBackground(GlobalConstants.BACKGROUND_COLOR);
        wrapper.add(image);
        wrapper.add(result);
        add(wrapper);
        pack();
        setVisible(true);
    }
}
