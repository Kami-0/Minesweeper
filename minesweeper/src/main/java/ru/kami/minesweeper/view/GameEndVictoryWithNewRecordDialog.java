package ru.kami.minesweeper.view;

import lombok.extern.slf4j.Slf4j;
import ru.kami.minesweeper.controller.Controller;
import ru.kami.minesweeper.view.constant.UIConstants;
import ru.kami.minesweeper.view.icon.MinesweeperImageIconRegistry;
import ru.kami.minesweeper.view.constant.GameEndDialogConstants;
import ru.kami.minesweeper.view.constant.GlobalConstants;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

@Slf4j
class GameEndVictoryWithNewRecordDialog extends JDialog {
    GameEndVictoryWithNewRecordDialog(Frame owner, Controller controller, int points) {
        super(owner, GameEndDialogConstants.WIN_DIALOG_TITLE, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        setLocationRelativeTo(owner);
        JLabel image = new JLabel();
        Optional<ImageIcon> imageIconOptional = MinesweeperImageIconRegistry.getUiImageIconMap(GameEndDialogConstants.WIN_DIALOG_ICON_CODE);
        if (imageIconOptional.isPresent()) {
            image.setIcon(imageIconOptional.get());
        } else {
            log.error("Ошибка в получении иконки c кодом: {}", GameEndDialogConstants.WIN_DIALOG_ICON_CODE);
        }
        JLabel result = new JLabel();
        String resultString = "Your points: " + points;
        result.setText(resultString);
        result.setFont(GlobalConstants.FONT);
        result.setForeground(Color.YELLOW);
        JLabel textNewRecord = new JLabel("New record! Enter your name:");
        textNewRecord.setForeground(Color.YELLOW);
        textNewRecord.setFont(GlobalConstants.FONT);
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(GameEndDialogConstants.TEXT_FIELD_WIDTH, GameEndDialogConstants.TEXT_FIELD_HEIGHT));
        JButton button = new JButton("accept");
        button.addActionListener(e -> {
            controller.handleUserAddPlayerName(textField.getText());
            setVisible(false);
        });

        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(GlobalConstants.BACKGROUND_COLOR);
        wrapper.add(image, getContainerGridBagConstrains(GameEndDialogConstants.IMAGE_GRID_X, GameEndDialogConstants.IMAGE_GRID_Y, GameEndDialogConstants.IMAGE_GRID_WIDTH, GameEndDialogConstants.IMAGE_GRID_HEIGHT));
        wrapper.add(result, getContainerGridBagConstrains(GameEndDialogConstants.RESULT_GRID_X, GameEndDialogConstants.RESULT_GRID_Y, GameEndDialogConstants.RESULT_GRID_WIDTH, GameEndDialogConstants.RESULT_GRID_HEIGHT));
        wrapper.add(textNewRecord, getContainerGridBagConstrains(GameEndDialogConstants.TEXT_NEW_RECORD_GRID_X, GameEndDialogConstants.TEXT_NEW_RECORD_GRID_Y, GameEndDialogConstants.TEXT_NEW_RECORD_GRID_WIDTH, GameEndDialogConstants.TEXT_NEW_RECORD_GRID_HEIGHT));
        wrapper.add(textField, getContainerGridBagConstrains(GameEndDialogConstants.TEXT_FIELD_GRID_X, GameEndDialogConstants.TEXT_FIELD_GRID_Y, GameEndDialogConstants.TEXT_FIELD_GRID_WIDTH, GameEndDialogConstants.TEXT_FIELD_GRID_HEIGHT));
        wrapper.add(button, getContainerGridBagConstrains(GameEndDialogConstants.BUTTON_GRID_X, GameEndDialogConstants.BUTTON_GRID_Y, GameEndDialogConstants.BUTTON_GRID_WIDTH, GameEndDialogConstants.BUTTON_GRID_HEIGHT));
        add(wrapper);
        pack();
        setVisible(true);
    }

    private GridBagConstraints getContainerGridBagConstrains(int gridX, int gridY, int gridWidth, int gridHeight) {
        return new GridBagConstraints(gridX, gridY, gridWidth, gridHeight,
                UIConstants.WEIGHT_X, UIConstants.WEIGHT_Y,
                GridBagConstraints.WEST, GridBagConstraints.WEST,
                new Insets(UIConstants.INSETS_TOP, UIConstants.INSETS_LEFT, UIConstants.INSETS_BOTTOM, UIConstants.INSETS_RIGHT),
                UIConstants.IPAD_X, UIConstants.IPAD_Y);
    }
}
