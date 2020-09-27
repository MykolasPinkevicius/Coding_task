package game;

import models.Ball;
import models.Bat;
import models.PingPongTable;
import models.ScoreBoard;
import util.Utilities;

import java.io.Serializable;

public class MykolasPingPongRules implements PingPongRules, Serializable {
    public static final char BAT_UP = 'w';
    public static final char BAT_DOWN = 's';

    private Ball ball;
    private Bat leftBat;
    private Bat rightBat;
    private ScoreBoard scoreBoard;
    private PingPongTable pingPongTable;
    private GameMovementImpl gameMovement;

    public MykolasPingPongRules(Ball ball, Bat leftBat, Bat rightBat, ScoreBoard scoreBoard, PingPongTable pingPongTable) {
        this.ball = ball;
        this.leftBat = leftBat;
        this.rightBat = rightBat;
        this.scoreBoard = scoreBoard;
        this.pingPongTable = pingPongTable;
        this.gameMovement = new GameMovementImpl(leftBat, rightBat, ball, pingPongTable);
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
    public void setLeftBat(Bat leftBat) {
        this.leftBat = leftBat;
    }
    public void setRightBat(Bat rightBat) {
        this.rightBat = rightBat;
    }
    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }
    public void setPingPongTable(PingPongTable pingPongTable) {
        this.pingPongTable = pingPongTable;
    }
    public Ball getBall() {
        return ball;
    }
    public Bat getLeftBat() {
        return leftBat;
    }
    public Bat getRightBat() {
        return rightBat;
    }
    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }
    public PingPongTable getPingPongTable() {
        return pingPongTable;
    }


    @Override
    public boolean pointScored(Bat bat) {
        return !gameMovement.isBallKnockedByBat(ball, bat) && pingPongTable.isBallEscaped(ball.getX(), ball.getY());
    }

    private String whichPlayerScored() {
        if (ball.getY() == 0 && !gameMovement.isBallKnockedByBat(ball, leftBat)) {
            return "RightBat";
        } else if (ball.getY() == 15 && !gameMovement.isBallKnockedByBat(ball, rightBat)){
            return "LeftBat";
        }
        return "Something not right";
    }

    @Override
    public void resetBallPositions() {
        ball.setY(8);
        ball.setX(5);
    }

    @Override
    public void resetLeftBatPosition() {
        leftBat.setY(1);
        leftBat.setX1(4);
        leftBat.setX2(5);
        leftBat.setX3(6);
    }

    @Override
    public void resetRightBatPosition() {
        rightBat.setY(13);
        rightBat.setX1(4);
        rightBat.setX2(5);
        rightBat.setX3(6);
    }

    @Override
    public void updateScore() {
        String winner = whichPlayerScored();
        if ("LeftBat".equalsIgnoreCase(winner)) {
            scoreBoard.setLeftBatScore(scoreBoard.getLeftBatScore() + 1);
        } else if ("RightBat".equalsIgnoreCase(winner)) {
            scoreBoard.setRightBatScore(scoreBoard.getRightBatScore() + 1);
        }
    }

    @Override
    public void moveBatUp() {
        gameMovement.moveBall();
        gameMovement.moveBat(BAT_UP);
        gameMovement.changeBallDirection();
        gameMovement.moveNPCBat();
        if (someoneScored()) {
            updateScore();
            displayScore();
            resetBallPositions();
            resetLeftBatPosition();
            resetRightBatPosition();
        }
    }

    @Override
    public void moveBatDown() {
        gameMovement.moveBall();
        gameMovement.moveBat(BAT_DOWN);
        gameMovement.changeBallDirection();
        gameMovement.moveNPCBat();
        if (someoneScored()) {
            updateScore();
            displayScore();
            resetBallPositions();
            resetLeftBatPosition();
            resetRightBatPosition();
        }
    }

    @Override
    public void returnLastGameData(MykolasPingPongRules lastGame) {
        setBall(lastGame.getBall());
        setLeftBat(lastGame.getLeftBat());
        setRightBat(lastGame.getRightBat());
        setPingPongTable(lastGame.getPingPongTable());
        setScoreBoard(lastGame.getScoreBoard());
        System.out.println("You resumed your last game");
        displayScore();
    }

    @Override
    public void skipMove() {
        gameMovement.moveBall();
        gameMovement.changeBallDirection();
        gameMovement.moveNPCBat();
        if (someoneScored()) {
            updateScore();
            displayScore();
            resetBallPositions();
            resetLeftBatPosition();
            resetRightBatPosition();
        }
    }
    @Override
    public boolean someoneScored() {
        return pointScored(leftBat) || pointScored(rightBat);
    }

    @Override
    public void displayScore() {
        System.out.println("Ball is out: Score is " + "Left bat " + scoreBoard.getLeftBatScore() + " : " + "Right Bat " + scoreBoard.getRightBatScore());
    }
}
