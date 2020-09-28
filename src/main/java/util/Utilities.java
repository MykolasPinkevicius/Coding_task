package util;


import java.util.Random;

public class Utilities {

    private Utilities(){}

    private static final int DIRECTION_RIGHT = 2;
    private static final int DIRECTION_LEFT = 1;
    private static final int VERTICAL_DIRECTION_UP = 4;
    private static final int VERTICAL_DIRECTION_DOWN = 1;
    private static Random random = new Random();

    public static int getRandomNumberForDirection() {
        return (random.nextInt(1) * (DIRECTION_RIGHT - DIRECTION_LEFT + 1)) + DIRECTION_LEFT;
    }

    public static int getRandomNumberForVerticalDirection() {
        return (random.nextInt(1) * (VERTICAL_DIRECTION_UP - VERTICAL_DIRECTION_DOWN)) + VERTICAL_DIRECTION_DOWN;
    }
}
