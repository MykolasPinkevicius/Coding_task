package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreBoardTest {
    @Test
    void shouldSetBatsScores() {
        final ScoreBoard scoreBoard = new ScoreBoard();
        int score = 1;

        scoreBoard.setRightBatScore(score);
        scoreBoard.setLeftBatScore(score);

        assertEquals(scoreBoard.getLeftBatScore(), score, "The bat score wasn't set correctly");
        assertEquals(scoreBoard.getRightBatScore(), score, "The bat score wasn't set correctly");
    }
}
