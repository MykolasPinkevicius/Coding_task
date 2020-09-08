package util;

public class Utilities {

    private static final int DIRECTION_RIGHT = 2;
    private static final int DIRECTION_LEFT = 1;
    public static int getRandomNumberForDirection() {
        return (int) Math.round(Math.random() * ((DIRECTION_RIGHT - DIRECTION_LEFT) + 1));
    }
}
