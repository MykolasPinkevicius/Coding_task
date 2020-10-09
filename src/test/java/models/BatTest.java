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

        assertEquals(x1Coordinate, bat.getX1(),"Bat x1 coordinate wasn't set correctly");
        assertEquals(x2Coordinate, bat.getX2(),"Bat x2 coordinate wasn't set correctly");
        assertEquals(x3Coordinate, bat.getX3(),"Bat x3 coordinate wasn't set correctly");
        assertEquals(yCoordinate, bat.getY(),"Bat y coordinate wasn't set correctly");
    }
    @Test
    void shouldReturnCorrectIcon() {
        final char BAT_ICON = '\u25A0';
        final Bat bat = new Bat();
        assertEquals(BAT_ICON, bat.getIcon(),"Bat icon returned not correctly");    }

    @Test
    void shouldSetBatStartingFinishingCoordinates() {
        int x1Coordinate = 4;
        int x2Coordinate = 5;
        int x3Coordinate = 6;
        int yCoordinate = 1;

        final Bat bat = new Bat(x1Coordinate, x2Coordinate,x3Coordinate,yCoordinate);

        assertEquals(x1Coordinate, bat.getStartingDrawingPointX(),"Starting x coordinate wasn't set correctly");
        assertEquals(x3Coordinate, bat.getFinishingDrawingPointX(),"Finishing x coordinate wasn't set correctly");
        assertEquals(yCoordinate, bat.getStartingDrawingPointY(),"Starting y coordinate wasn't set correctly");
        assertEquals(yCoordinate, bat.getFinishingDrawingPointY(),"FInishing y coordinate wasn't set correctly");
    }
}
