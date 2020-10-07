package game;

import models.Ball;
import models.Bat;
import models.PingPongTable;
import models.ScoreBoard;

import java.io.Serializable;
import java.util.logging.Logger;

public class MykolasPingPongRules implements PingPongRules, Serializable {
    private static final Logger logger = Logger.getLogger(MykolasPingPongRules.class.getName());
    public static final char BAT_UP = 'w';
    public static final char BAT_DOWN = 's';

    private Ball ball;
    private Bat leftBat;
    private Bat rightBat;
    private ScoreBoard scoreBoard;
    private PingPongTable pingPongTable;
    private transient GameMovementImpl gameMovement;

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
    public boolean someoneScored() {
        return pointScored(leftBat) || pointScored(rightBat);
    }

    @Override
    public void displayScore() {
        logger.info("Ball is out: Score is " + "Left bat " + scoreBoard.getLeftBatScore() + " : " + "Right Bat " + scoreBoard.getRightBatScore());
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
    public void activateMoveBatUp() {
        gameMovement.moveBat(BAT_UP);
        gameMovement.activateBallWithNpcMovement();
        ifSomeoneScoredUpdateIt();
    }

    @Override
    public void activateMoveBatDown() {
        gameMovement.moveBat(BAT_DOWN);
        gameMovement.activateBallWithNpcMovement();
        ifSomeoneScoredUpdateIt();
    }

    @Override
    public void returnLastGameData(MykolasPingPongRules lastGame) {
        setBall(lastGame.getBall());
        setLeftBat(lastGame.getLeftBat());
        setRightBat(lastGame.getRightBat());
        setPingPongTable(lastGame.getPingPongTable());
        setScoreBoard(lastGame.getScoreBoard());
        logger.info("You resumed your last game");
        displayScore();
    }

    @Override
    public void skipMove() {
        gameMovement.activateBallWithNpcMovement();
        ifSomeoneScoredUpdateIt();
    }

    private void ifSomeoneScoredUpdateIt() {
        if (someoneScored()) {
            updateScore();
            displayScore();
            resetGameItemPositions();
        }
    }

    private void resetGameItemPositions() {
        resetBallPositions();
        resetLeftBatPosition();
        resetRightBatPosition();
    }

    private void resetBallPositions() {
        ball.setY(8);
        ball.setX(5);
    }

    private void resetLeftBatPosition() {
        leftBat.setY(1);
        leftBat.setX1(4);
        leftBat.setX2(5);
        leftBat.setX3(6);
    }

    private void resetRightBatPosition() {
        rightBat.setY(13);
        rightBat.setX1(4);
        rightBat.setX2(5);
        rightBat.setX3(6);
    }
}
