package ru.kami.minesweeper.view;

import lombok.extern.slf4j.Slf4j;
import ru.kami.minesweeper.controller.Controller;
import ru.kami.minesweeper.view.entity.GameNewEnterJButton;
import ru.kami.minesweeper.view.entity.NumberJTextField;
import ru.kami.minesweeper.view.icon.MinesweeperImageIconRegistry;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static ru.kami.minesweeper.view.constant.GameNewUIConstants.*;
import static ru.kami.minesweeper.view.constant.GlobalConstants.BACKGROUND_COLOR;

@Slf4j
class GameNewDialog extends JDialog {

    public GameNewDialog(Frame owner, Controller controller) {
        super(owner, DIALOG_TITLE, true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(owner);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setBackground(BACKGROUND_COLOR);
        optionsPanel.setLayout(
                new GridLayout(GRID_LAYOUT_ROWS, GRID_LAYOUT_COLUMNS, GRID_LAYOUT_GAP_HEIGHT, GRID_LAYOUT_GAP_WIDTH));

        Map<GameNewOptions, NumberJTextField> jNumberTextFieldMap = new HashMap<>();
        for (GameNewOptions option : GameNewOptions.values()) {
            jNumberTextFieldMap.put(option, new NumberJTextField());
            optionsPanel.add(getJLabelWithIcon(option));
            optionsPanel.add(jNumberTextFieldMap.get(option));
        }

        GameNewEnterJButton enterButton = new GameNewEnterJButton(
                owner,
                controller,
                jNumberTextFieldMap.get(GameNewOptions.GRID_WIDTH),
                jNumberTextFieldMap.get(GameNewOptions.GRID_HEIGHT),
                jNumberTextFieldMap.get(GameNewOptions.MINES));
        JPanel dialogWrapper = new JPanel();
        dialogWrapper.setBackground(BACKGROUND_COLOR);
        dialogWrapper.add(optionsPanel);
        dialogWrapper.add(enterButton);
        add(dialogWrapper);
        setVisible(false);
    }

    private JLabel getJLabelWithIcon(GameNewOptions code) {
        JLabel jLabel = new JLabel();
        Optional<ImageIcon> imageIconOptional = MinesweeperImageIconRegistry.getNewGameOptionsImageIconMap(code);
        if (imageIconOptional.isPresent()) {
            jLabel.setIcon(imageIconOptional.get());
        } else {
            log.error("Ошибка в получении иконки c кодом: {},", code);
        }
        return jLabel;
    }
}
