package game;

import models.Ball;
import models.Bat;
import models.PingPongTable;
import util.Utilities;

public class GameMovementImpl implements GameMovement {
    private static final int MOVING_UP = 1;
    private static final int MOVING_DOWN = -1;
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
            rightBat.setX1(rightBat.getX1() + MOVING_UP);
            rightBat.setX2(rightBat.getX2() + MOVING_UP);
            rightBat.setX3(rightBat.getX3() + MOVING_UP);
        } else if (ball.getX() < rightBat.getX2()) {
            rightBat.setX1(rightBat.getX1() + MOVING_DOWN);
            rightBat.setX2(rightBat.getX2() + MOVING_DOWN);
            rightBat.setX3(rightBat.getX3() + MOVING_DOWN);
        }
    }

    @Override
    public void moveBall() {
        switch(ball.getDirection()){
            case 1:
                tryMoveBall(-1);
                break;
            case 2:
                tryMoveBall(1);
                break;
        }
    }

    private void tryMoveBall(int moveY) {
        if (!pingPongTable.isBallBouncedToWall(ball.getX() + whichDirectionBallGoes(ball.getVerticalDirection()), ball.getY() + moveY )) {
            moveBallItsDirection(moveY);
        } else if(pingPongTable.isBallBouncedToWall(ball.getX() + whichDirectionBallGoes(ball.getVerticalDirection()), ball.getY() + moveY)) {
            if (ball.getVerticalDirection() == 3) {
                ball.setVerticalDirection(1);
                moveBallItsDirection(moveY);
            } else if (ball.getVerticalDirection() == 1) {
                ball.setVerticalDirection(3);
                moveBallItsDirection(moveY);
            }
        }
    }

    private void moveBallItsDirection(int moveY) {
        ball.setX(ball.getX() + whichDirectionBallGoes(ball.getVerticalDirection()));
        ball.setY(ball.getY() + moveY);
    }

    private int whichDirectionBallGoes(int verticalDirection) {
        int moveX;
        switch(verticalDirection) {
            case 1 : moveX = -1;
                break;
            case 3 : moveX = 1;
                break;
            default:  moveX = 0;
                break;
        }
        return moveX;
    }

    @Override
    public void moveBat(char direction) {
        switch (direction) {
            case 's':
                tryMoveBat(1, leftBat);
                break;
            case 'w' :
                tryMoveBat(-1, leftBat);
                break;
        }
    }

    private void tryMoveBat(int moveX, Bat bat) {
        if (moveX == MOVING_UP) {
            if (!pingPongTable.isBatBumpToWall(bat.getX3()+moveX,bat.getY())) {
                bat.setX1(bat.getX1()+moveX);
                bat.setX2(bat.getX2()+moveX);
                bat.setX3(bat.getX3()+moveX);
            }
        } else if (moveX == MOVING_DOWN) {
            if (!pingPongTable.isBatBumpToWall(bat.getX1()+moveX,bat.getY())) {
                bat.setX1(bat.getX1()+moveX);
                bat.setX2(bat.getX2()+moveX);
                bat.setX3(bat.getX3()+moveX);
            }
        }
    }

    @Override
    public void changeBallDirection() {
        if (isBallKnockedByBat(ball, leftBat)) {
            changeBallVerticalDirection();
            changeBallHorizontalDirection();
        } else if (isBallKnockedByBat(ball, rightBat)) {
            changeBallVerticalDirection();
            changeBallHorizontalDirection();
        }
    }

    private void changeBallVerticalDirection() {
        ball.setVerticalDirection(Utilities.getRandomNumberForVerticalDirection());
    }

    private void changeBallHorizontalDirection() {
        if (ball.getDirection() == 1) {
            ball.setDirection(2);
        } else if (ball.getDirection() == 2) {
            ball.setDirection(1);
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

}
