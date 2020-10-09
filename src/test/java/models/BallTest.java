package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BallTest {
    @Test
    void shouldSetBallInstanceVariables() {
        int x = 5;
        int y = 7;
        int direction = 1;
        int verticalDirection = 1;
        final Ball ball = new Ball();

        ball.setX(x);
        ball.setY(y);
        ball.setDirection(1);
        ball.setVerticalDirection(1);

        assertEquals(ball.getX(), x, "Ball x coordinate wasn't set correctly");
        assertEquals(ball.getY(), y, "Ball y coordinate wasn't set correctly");
        assertEquals(ball.getDirection(), direction, "Ball direction wasn't set correctly");
        assertEquals(ball.getVerticalDirection(), verticalDirection, "Ball vertical direction wasn't set correctly");
    }
    @Test
    void shouldReturnCorrectIcon() {
        final char BALL_ICON = '\u25CF';
        final Ball ball = new Ball();
        assertEquals(ball.getIcon(), BALL_ICON, "Ball Icon retuned not correctly");
    }
    @Test
    void shouldSetBallStartingFinishingCoordinates() {
        int x = 5;
        int y = 7;
        int direction = 1;
        int verticalDirection = 1;
        final Ball ball = new Ball(x,y, direction, verticalDirection);

        assertEquals(ball.getStartingDrawingPointX(), x, "Starting X drawing position wasn't set correctly");
        assertEquals(ball.getFinishingDrawingPointX(), x, "Finishing X drawing position wasn't set correctly");
        assertEquals(ball.getStartingDrawingPointY(), y, "Starting Y drawing position wasn't set correctly");
        assertEquals(ball.getFinishingDrawingPointY(), y, "Finishing Y drawing position wasn't set correctly");
    }
}
