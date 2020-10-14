package game;

import models.Ball;
import models.Bat;
import models.PingPongTable;
import util.Utilities;

public class GameMovementImpl implements GameMovement {
    private static final int BAT_MOVING_UP = -1;
    private static final int BAT_MOVING_DOWN = 1;
    public static final int VERTICAL_DIRECTION_DOWN = 3;
    public static final int VERTICAL_DIRECTION_UP = 1;
    public static final int HORIZONTAL_DIRECTION_LEFT = 1;
    public static final int HORIZONTAL_DIRECTION_RIGHT = 2;
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
            setNewNPCBatPosition(BAT_MOVING_DOWN);
        }
        if (ball.getX() < rightBat.getX2()) {
            setNewNPCBatPosition(BAT_MOVING_UP);
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
        if (ball.getVerticalDirection() == VERTICAL_DIRECTION_DOWN) {
            ball.setVerticalDirection(VERTICAL_DIRECTION_UP);
        } else {
            ball.setVerticalDirection(VERTICAL_DIRECTION_DOWN);
        }
    }

    private void moveBallItsDirection() {
        ball.setX(ball.getNextPotentialVerticalXPoint());
        ball.setY(ball.getNextPotentialHorizontalYPoint());
    }

    @Override
    public void movePlayerBatUp() {
        if (!pingPongTable.isBatBumpToWall(leftBat.getX1() + BAT_MOVING_UP, leftBat.getY())) {
            setNewPlayerBatPosition(BAT_MOVING_UP);
        }
    }

    @Override
    public void movePlayerBatDown() {
        if (!pingPongTable.isBatBumpToWall(leftBat.getX3() + BAT_MOVING_DOWN, leftBat.getY())) {
            setNewPlayerBatPosition(BAT_MOVING_DOWN);
        }
    }

    private void setNewPlayerBatPosition(int playerBatMove) {
        leftBat.setX1(leftBat.getX1() + playerBatMove);
        leftBat.setX2(leftBat.getX2() + playerBatMove);
        leftBat.setX3(leftBat.getX3() + playerBatMove);
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
        if (ball.getHorizontalDirection() == HORIZONTAL_DIRECTION_LEFT) {
            ball.setHorizontalDirection(HORIZONTAL_DIRECTION_RIGHT);
        } else {
            ball.setHorizontalDirection(HORIZONTAL_DIRECTION_LEFT);
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
