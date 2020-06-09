package ru.kami.minesweeper.view;

import lombok.extern.slf4j.Slf4j;
import ru.kami.minesweeper.view.entity.HighScoreTableTitleJLabel;
import ru.kami.minesweeper.view.entity.ResultView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static ru.kami.minesweeper.view.constant.GlobalConstants.BACKGROUND_COLOR;
import static ru.kami.minesweeper.view.constant.HighScoreTableConstants.TITLE;

@Slf4j
class HighScoreTableDialog extends JDialog {
    public HighScoreTableDialog(Frame owner, List<ResultView> resultViews) {
        super(owner, TITLE, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(owner);

        List<String> titlesList = new ArrayList<>();
        titlesList.add("NAME");
        titlesList.add("ROWS");
        titlesList.add("COLUMNS");
        titlesList.add("MINES");
        titlesList.add("SECONDS");
        titlesList.add("POINTS");
        JPanel titleWrapper = new JPanel();
        titleWrapper.setBackground(BACKGROUND_COLOR);
        titlesList.forEach(title -> {
            HighScoreTableTitleJLabel highScoreTableTitleJLabel = new HighScoreTableTitleJLabel(title);
            titleWrapper.add(highScoreTableTitleJLabel);
        });

        JPanel dialogWrapper = new JPanel();
        dialogWrapper.setLayout(new BoxLayout(dialogWrapper, BoxLayout.Y_AXIS));
        dialogWrapper.setBackground(BACKGROUND_COLOR);
        dialogWrapper.add(titleWrapper);
        resultViews.forEach(dialogWrapper::add);
        add(dialogWrapper);
        pack();
        setVisible(true);
    }
}
