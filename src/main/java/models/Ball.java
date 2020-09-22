package models;

import java.io.Serializable;

public class Ball implements Serializable {
    public static final int STRAIGHT_DIRECTION = 2;
    public static char BALL_ICON = 'B';
    private int x;
    private int y;
    private int direction;
    private int verticalDirection;

    public Ball(int x, int y, int direction, int verticalDirection) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.verticalDirection = verticalDirection;
    }

    public int getVerticalDirection() {
        return verticalDirection;
    }

    public void setVerticalDirection(int verticalDirection) {
        this.verticalDirection = verticalDirection;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
