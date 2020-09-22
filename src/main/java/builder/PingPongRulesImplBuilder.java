package builder;

import game.PingPongRulesImpl;
import models.Ball;
import models.Bat;
import models.PingPongTable;
import models.ScoreBoard;

public class PingPongRulesImplBuilder {
    private Bat leftBat;
    private Bat rightBat;
    private Ball ball;
    private ScoreBoard scoreBoard;
    private PingPongTable pingPongTable;

    public PingPongRulesImplBuilder setLeftBat(Bat leftBat) {
        this.leftBat = leftBat;
        return this;
    }
    public PingPongRulesImplBuilder setRightBat(Bat rightBat) {
        this.rightBat = rightBat;
        return this;
    }
    public PingPongRulesImplBuilder setBall(Ball ball) {
        this.ball = ball;
        return this;
    }
    public PingPongRulesImplBuilder setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        return this;
    }
    public PingPongRulesImplBuilder setPingPongTable(PingPongTable pingPongTable) {
        this.pingPongTable = pingPongTable;
        return this;
    }
    public PingPongRulesImpl build() {
        return new PingPongRulesImpl(ball,leftBat,rightBat,scoreBoard,pingPongTable);
    }
}
