package builder;

import game.MykolasPingPongRules;
import models.Ball;
import models.Bat;
import models.PingPongTable;
import models.ScoreBoard;

public class MykolasPingPongRulesBuilder {
    private Bat leftBat;
    private Bat rightBat;
    private Ball ball;
    private ScoreBoard scoreBoard;
    private PingPongTable pingPongTable;

    public MykolasPingPongRulesBuilder setLeftBat(Bat leftBat) {
        this.leftBat = leftBat;
        return this;
    }
    public MykolasPingPongRulesBuilder setRightBat(Bat rightBat) {
        this.rightBat = rightBat;
        return this;
    }
    public MykolasPingPongRulesBuilder setBall(Ball ball) {
        this.ball = ball;
        return this;
    }
    public MykolasPingPongRulesBuilder setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        return this;
    }
    public MykolasPingPongRulesBuilder setPingPongTable(PingPongTable pingPongTable) {
        this.pingPongTable = pingPongTable;
        return this;
    }
    public MykolasPingPongRules build() {
        return new MykolasPingPongRules(ball,leftBat,rightBat,scoreBoard,pingPongTable);
    }
}
