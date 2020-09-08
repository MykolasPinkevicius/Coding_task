package util;

import Items.Ball;
import Items.Bat;
import Items.PingPongTable;

import java.io.IOException;

public class Renderer {

    private char[][] tableOfCharacters = {
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
    };

    public void drawMap(PingPongTable table) throws IOException {
        for (int row = 0; row < tableOfCharacters.length; row++) {
            for (int col = 0; col < tableOfCharacters[row].length; col++) {
                if (col < 1) {
                    System.out.print("\t" + tableOfCharacters[row][col]);
                } else {
                    System.out.print("\t" + tableOfCharacters[row][col]);
                }
            }
            System.out.println();
        }

    }
    public void drawBall(Ball ball) throws IOException {
        tableOfCharacters[ball.getX()][ball.getY()] = 'B';
    }

    public void drawBat(Bat bat) throws IOException {
        tableOfCharacters[bat.getX1()][bat.getY()] = 'R';
        tableOfCharacters[bat.getX2()][bat.getY()] = 'R';
        tableOfCharacters[bat.getX3()][bat.getY()] = 'R';
    }

    public void drawBallAndBats(Bat leftBat, Bat rightBat, Ball ball, PingPongTable pingPongTable) throws IOException {
        drawBall(ball);
        drawBat(leftBat);
        drawBat(rightBat);
        drawMap(pingPongTable);
    }

    public void clearBallAndBat(Bat leftBat, Bat rightBat, Ball ball) {
        clearBat(leftBat);
        clearBat(rightBat);
        clearBall(ball);
    }

    private void clearBall(Ball ball) {
        tableOfCharacters[ball.getX()][ball.getY()] = 'e';
    }

    private void clearBat(Bat bat) {
        tableOfCharacters[bat.getX1()][bat.getY()] = 'e';
        tableOfCharacters[bat.getX2()][bat.getY()] = 'e';
        tableOfCharacters[bat.getX3()][bat.getY()] = 'e';
    }
}
