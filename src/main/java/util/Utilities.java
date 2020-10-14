package util;


import java.util.Random;

public class Utilities {

    private Utilities(){}

    private static final int MORE_THAN_ZERO = 1;
    private static final Random random = new Random();

    public static int getRandomNumberForHorizontalDirection() {
        return (random.nextInt(2)) + MORE_THAN_ZERO;
    }

    public static int getRandomNumberForVerticalDirection() {
        return (random.nextInt(3)) + MORE_THAN_ZERO;
    }
}
