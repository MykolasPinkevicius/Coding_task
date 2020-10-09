package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PingPongTableTest {
    @Test
    void isBallEscapedGivenCoordinateArgumentsShouldReturnTrue() {
        final PingPongTable pingPongTable = new PingPongTable();
        int xCoordinate = 0;
        int yCoordinate = 0;

        boolean result = pingPongTable.isBallEscaped(xCoordinate,yCoordinate);

        assertTrue(result, "The isBallEscaped did not returned correct value");
    }
    @Test
    void isBallBouncedToWallGivenCoordinateArgumentsShouldReturnTure() {
        final PingPongTable pingPongTable = new PingPongTable();
        int xCoordinate = 0;
        int yCoordinate = 1;

        boolean result = pingPongTable.isBallBouncedToWall(xCoordinate, yCoordinate);

        assertTrue(result, "The isBallBouncedToWall did not returned correct value");
    }
    @Test
    void isBatBumpToWall() {
        final PingPongTable pingPongTable = new PingPongTable();
        int xCoordinate = 0;
        int yCoordinate = 1;

        boolean result = pingPongTable.isBatBumpToWall(xCoordinate, yCoordinate);

        assertTrue(result, "The isBatBumpToWall did not return correct value");
    }
}
