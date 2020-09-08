package game;

import Items.Ball;
import Items.Bat;

public interface PingPongRules {
    boolean pointScored(Bat bat);
    void changeBallDirection(Bat bat, Ball ball);
    void resetBallPositions();
    void resetLeftBatPosition();
    void resetRightBatPosition();
    void updateScore();
    void moveBat(char direction, Bat bat);
    void moveBall();
}
