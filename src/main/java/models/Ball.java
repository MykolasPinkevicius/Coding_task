package models;

import game.Movable;
import render.Drawable;

import java.io.Serializable;

public class Ball implements Serializable, Drawable, Movable {
    public static final char BALL_ICON = '\u25CF';
    private int x;
    private int y;
    private int horizontalDirection;
    private int verticalDirection;

    public Ball() {}

    public Ball(int x, int y, int horizontalDirection, int verticalDirection) {
        this.x = x;
        this.y = y;
        this.horizontalDirection = horizontalDirection;
        this.verticalDirection = verticalDirection;
    }

    public int getVerticalDirection() {
        return verticalDirection;
    }

    public void setVerticalDirection(int verticalDirection) {
        this.verticalDirection = verticalDirection;
    }

    public int getHorizontalDirection() {
        return horizontalDirection;
    }

    public void setHorizontalDirection(int horizontalDirection) {
        this.horizontalDirection = horizontalDirection;
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

    @Override
    public int getStartingDrawingPointX() {
        return getX();
    }

    @Override
    public int getStartingDrawingPointY() {
        return getY();
    }

    @Override
    public int getFinishingDrawingPointX() {
        return getX();
    }

    @Override
    public int getFinishingDrawingPointY() {
        return getY();
    }

    @Override
    public char getIcon() {
        return BALL_ICON;
    }

    @Override
    public int getNextPotentialVerticalXPoint() {
        if (getVerticalDirection() == 1) {
            return getX() - 1;
        } else {
            return getX() + 1;
        }
    }

    @Override
    public int getNextPotentialHorizontalYPoint() {
        if (getHorizontalDirection() == 2) {
            return getY() + 1;
        } else {
            return getY() - 1;
        }
    }
}
