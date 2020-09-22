package models;

import java.io.Serializable;

public class ScoreBoard implements Serializable {
    private int leftBatScore;
    private int rightBatScore;

    public int getLeftBatScore() {
        return leftBatScore;
    }

    public void setLeftBatScore(int leftBatScore) {
        this.leftBatScore = leftBatScore;
    }

    public int getRightBatScore() {
        return rightBatScore;
    }

    public void setRightBatScore(int rightBatScore) {
        this.rightBatScore = rightBatScore;
    }
}
