package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BatTest {
    @Test
    void shouldSetBatInstanceVariables() {
        int x1Coordinate = 4;
        int x2Coordinate = 5;
        int x3Coordinate = 6;
        int yCoordinate = 1;
        final Bat bat = new Bat();

        bat.setX1(x1Coordinate);
        bat.setX2(x2Coordinate);
        bat.setX3(x3Coordinate);
        bat.setY(yCoordinate);

        assertEquals(bat.getX1(), x1Coordinate, "Bat x1 coordinate wasn't set correctly");
        assertEquals(bat.getX2(), x2Coordinate, "Bat x2 coordinate wasn't set correctly");
        assertEquals(bat.getX3(), x3Coordinate, "Bat x3 coordinate wasn't set correctly");
        assertEquals(bat.getY(), yCoordinate, "Bat y coordinate wasn't set correctly");
    }
    @Test
    void shouldReturnCorrectIcon() {
        final char batIcon = '\u25A0';
        final Bat bat = new Bat();
        char result = bat.getIcon();
        assertEquals(batIcon, result, "Bat returned bad icon");
    }

    @Test
    void shouldSetBatStartingFinishingCoordinates() {
        int x1Coordinate = 4;
        int x2Coordinate = 5;
        int x3Coordinate = 6;
        int yCoordinate = 1;

        final Bat bat = new Bat(x1Coordinate, x2Coordinate,x3Coordinate,yCoordinate);

        assertEquals(bat.getStartingDrawingPointX(), x1Coordinate, "Starting x coordinate wasn't set correctly");
        assertEquals(bat.getFinishingDrawingPointX(), x3Coordinate, "Finishing x coordinate wasn't set correctly");
        assertEquals(bat.getStartingDrawingPointY(), yCoordinate, "Starting y coordinate wasn't set correctly");
        assertEquals(bat.getFinishingDrawingPointY(), yCoordinate, "FInishing y coordinate wasn't set correctly");
    }
}
