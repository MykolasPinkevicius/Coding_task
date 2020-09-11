package game;

import Items.Ball;
import Items.Bat;

public interface PingPongRules {
    boolean pointScored(Bat bat);
    void changeBallDirection();
    void resetBallPositions();
    void resetLeftBatPosition();
    void resetRightBatPosition();
    void updateScore();
    void moveBat(char direction);
    void moveBall();
    boolean someoneScored();
    void displayScore();
    Ball getBall();
    Bat getLeftBat();
    Bat getRightBat();
}
