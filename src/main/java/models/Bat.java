package models;

import render.Drawable;

import java.io.Serializable;

public class Bat implements Serializable, Drawable {
    private int x1;
    private int x2;
    private int x3;
    private int y;

    public Bat(int x1, int x2, int x3, int y) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y = y;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getStartingDrawingPointX() {
        return getX1();
    }

    @Override
    public int getStartingDrawingPointY() {
        return getY();
    }

    @Override
    public int getFinishingDrawingPointX() {
        return getX3();
    }

    @Override
    public int getFinishingDrawingPointY() {
        return getY();
    }

    @Override
    public char getIcon() {
        return '\u25A0';
    }
}
