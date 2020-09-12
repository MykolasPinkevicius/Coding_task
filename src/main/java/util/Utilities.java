package util;

import Items.Ball;
import Items.Bat;
import Items.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    private static final int DIRECTION_RIGHT = 2;
    private static final int DIRECTION_LEFT = 1;
    private static final int VERTICAL_DIRECTION_UP = 3;
    private static final int VERTICAL_DIRECTION_DOWN = 1;

    public static int getRandomNumberForDirection() {
        return (int) Math.random() * (DIRECTION_RIGHT - DIRECTION_LEFT + 1) + DIRECTION_LEFT;
    }

    public static List<Coordinate> InputCoordinatesFromObject(Ball ball) {
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(ball.getX(),ball.getY()));
        return coordinates;
    }
    public static List<Coordinate> InputCoordinatesFromObject(Bat bat) {
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(bat.getX1(), bat.getY()));
        coordinates.add(new Coordinate(bat.getX2(), bat.getY()));
        coordinates.add(new Coordinate(bat.getX3(), bat.getY()));
        return coordinates;
    }

    public static int getRandomBUmberForVerticalDirection() {
        return (int) Math.random() * (VERTICAL_DIRECTION_UP - VERTICAL_DIRECTION_DOWN + 1) + VERTICAL_DIRECTION_DOWN;
    }
}
