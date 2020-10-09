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

        assertEquals(score, scoreBoard.getLeftBatScore(),"The bat score wasn't set correctly");
        assertEquals(score, scoreBoard.getRightBatScore(),"The bat score wasn't set correctly");
    }
}
