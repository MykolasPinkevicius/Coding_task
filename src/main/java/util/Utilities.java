package util;


public class Utilities {

    private static final int DIRECTION_RIGHT = 2;
    private static final int DIRECTION_LEFT = 1;
    private static final int VERTICAL_DIRECTION_UP = 4;
    private static final int VERTICAL_DIRECTION_DOWN = 1;

    public static int getRandomNumberForDirection() {
        return (int) (Math.random() * (DIRECTION_RIGHT - DIRECTION_LEFT + 1)) + DIRECTION_LEFT;
    }

    public static int getRandomNumberForVerticalDirection() {
        return (int) (Math.random() * (VERTICAL_DIRECTION_UP - VERTICAL_DIRECTION_DOWN)) + VERTICAL_DIRECTION_DOWN;
    }
}
