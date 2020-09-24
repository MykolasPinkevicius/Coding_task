package game;

import models.Ball;
import models.Bat;
import models.PingPongTable;
import models.ScoreBoard;

public interface PingPongRules {
    void setBall(Ball ball);
    void setLeftBat(Bat leftBat);
    void setRightBat(Bat rightBat);
    void setScoreBoard(ScoreBoard scoreBoard);
    void setPingPongTable(PingPongTable pingPongTable);
    boolean pointScored(Bat bat);
    void changeBallDirection();
    void resetBallPositions();
    void resetLeftBatPosition();
    void resetRightBatPosition();
    void updateScore();
    void moveBatUp();
    void moveBatDown();
    void moveBat(char direction);
    void returnLastGameData(PingPongRules pingPongRules);
    void skipMove();
    void moveBall();
    boolean someoneScored();
    void displayScore();
    void moveNPCBat();
    ScoreBoard getScoreBoard();
    PingPongTable getPingPongTable();
    Ball getBall();
    Bat getLeftBat();
    Bat getRightBat();
}
