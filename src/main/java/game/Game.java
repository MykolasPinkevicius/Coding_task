package game;

import Items.ScoreBoard;

public class Game {
    private ScoreBoard scoreBoard;

    public Game(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }
}
