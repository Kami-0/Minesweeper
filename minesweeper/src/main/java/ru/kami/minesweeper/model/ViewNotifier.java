package ru.kami.minesweeper.model;

import lombok.NoArgsConstructor;
import ru.kami.minesweeper.api.Result;
import ru.kami.minesweeper.view.GameView;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
final class ViewNotifier {
    private final List<GameView> views = new ArrayList<>();

    void attachView(GameView crossView) {
        views.add(crossView);
    }

    void notifyViewNewCellStatus(int row, int column, String status) {
        views.forEach(crossView -> crossView.updateCell(row, column, status));
    }

    void notifyViewMinLeft(int status) {
        views.forEach(crossView -> crossView.updateMinLeftStatus(status));
    }

    void notifyViewsNewTimerStatus(int status) {
        views.forEach(crossView -> crossView.updateTimerStatus(status));
    }

    void notifyViewsLoss() {
        views.forEach(GameView::renderLoss);
    }

    void notifyViewsVictory(int successRate) {
        views.forEach(crossView -> crossView.renderVictory(successRate));
    }

    void notifyViewsVictoryWithNewRecord(int successRate) {
        views.forEach(crossView -> crossView.renderVictoryWithNewRecord(successRate));
    }

    void notifyViewsHighScore(Result[] result) {
        views.forEach(crossView -> crossView.renderHighScore(result));
    }

}