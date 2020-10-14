package game;

import models.Ball;
import models.Bat;
import models.PingPongTable;
import util.Utilities;

public class GameMovementImpl implements GameMovement {
    private static final int MOVING_UP = 1;
    private static final int MOVING_DOWN = -1;
    public static final int PLAYER_BAT_MOVING_UP = -1;
    public static final int PLAYER_BAT_MOVING_DOWN = 1;
    private PingPongTable pingPongTable;
    private Bat leftBat;
    private Bat rightBat;
    private Ball ball;

    public GameMovementImpl(Bat leftBat, Bat rightBat, Ball ball, PingPongTable pingPongTable) {
        this.leftBat = leftBat;
        this.rightBat = rightBat;
        this.ball = ball;
        this.pingPongTable = pingPongTable;
    }

    @Override
    public void moveNPCBat() {
        if (ball.getX() > rightBat.getX2()) {
            setNewNPCBatPosition(MOVING_UP);
        }
        if (ball.getX() < rightBat.getX2()) {
            setNewNPCBatPosition(MOVING_DOWN);
        }
    }

    private void setNewNPCBatPosition(int npcBatMovingDirection) {
        rightBat.setX1(rightBat.getX1() + npcBatMovingDirection);
        rightBat.setX2(rightBat.getX2() + npcBatMovingDirection);
        rightBat.setX3(rightBat.getX3() + npcBatMovingDirection);
    }

    public void moveBall() {
        if (pingPongTable.isBallBouncedToWall(ball.getNextPotentialVerticalXPoint(), ball.getNextPotentialHorizontalYPoint())) {
            changeBallVerticalPositionAfterBumpingToWall();
        } else {
            moveBallItsDirection();
        }
    }

    private void changeBallVerticalPositionAfterBumpingToWall() {
        if (ball.getVerticalDirection() == 3) {
            ball.setVerticalDirection(1);
        } else {
            ball.setVerticalDirection(3);
        }
    }

    private void moveBallItsDirection() {
        ball.setX(ball.getNextPotentialVerticalXPoint());
        ball.setY(ball.getNextPotentialHorizontalYPoint());
    }

    @Override
    public void movePlayerBatUp() {
        if (!pingPongTable.isBatBumpToWall(leftBat.getX1() + PLAYER_BAT_MOVING_UP, leftBat.getY())) {
            setNewPlayerBatPosition(PLAYER_BAT_MOVING_UP);
        }
    }

    @Override
    public void movePlayerBatDown() {
        if (!pingPongTable.isBatBumpToWall(leftBat.getX3() + PLAYER_BAT_MOVING_DOWN, leftBat.getY())) {
            setNewPlayerBatPosition(PLAYER_BAT_MOVING_DOWN);
        }
    }

    private void setNewPlayerBatPosition(int playerBatMovingUp) {
        leftBat.setX1(leftBat.getX1() + playerBatMovingUp);
        leftBat.setX2(leftBat.getX2() + playerBatMovingUp);
        leftBat.setX3(leftBat.getX3() + playerBatMovingUp);
    }

    @Override
    public void changeBallDirection() {
        if (isBallKnockedByBat(ball, leftBat) || (isBallKnockedByBat(ball, rightBat))) {
            changeBallVerticalAndHorizontalPosition();
        }
    }

    public void changeBallVerticalAndHorizontalPosition() {
        changeBallVerticalDirection();
        changeBallHorizontalDirection();
    }

    private void changeBallVerticalDirection() {
        ball.setVerticalDirection(Utilities.getRandomNumberForVerticalDirection());
    }

    private void changeBallHorizontalDirection() {
        if (ball.getHorizontalDirection() == 1) {
            ball.setHorizontalDirection(2);
        } else {
            ball.setHorizontalDirection(1);
        }
    }

    public boolean isBallKnockedByBat(Ball ball, Bat bat) {
        return isBallOnBatWidth(ball, bat) && isBallOnBatHeight(ball, bat);
    }

    private boolean isBallOnBatWidth(Ball ball, Bat bat) {
        return ball.getY() == bat.getY();
    }

    private boolean isBallOnBatHeight(Ball ball, Bat bat) {
        return ball.getX() == bat.getX1() || ball.getX() == bat.getX2() || ball.getX() == bat.getX3();
    }

    void activateBallWithNpcMovement() {
        moveBall();
        changeBallDirection();
        moveNPCBat();
    }
}
