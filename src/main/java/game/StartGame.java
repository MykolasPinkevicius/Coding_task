package game;

import Items.Ball;
import Items.Bat;
import Items.PingPongTable;
import Items.ScoreBoard;
import util.Renderer;
import util.Utilities;

import java.io.IOException;
import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) throws IOException {
        ScoreBoard score = new ScoreBoard();
        PingPongTable pingPongTable = new PingPongTable();
        Bat leftBat = new Bat(4,5,6, 1);
        Bat rightBat = new Bat(4,5,6,13);
        Ball ball = new Ball(5,7, Utilities.getRandomNumberForDirection(), Ball.STRAIGHT_DIRECTION);
        PingPongRules pingPongRules = new PingPongRulesImpl(ball, leftBat, rightBat, score, pingPongTable);
        Renderer renderer = new Renderer();
        renderer.drawBallAndBats(leftBat, rightBat, ball, pingPongTable);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input w to make bat go up, s to go down, q to quit game");
        char userInput = scanner.next().charAt(0);
        char quit = 'q';

        while(userInput != quit) {
            renderer.clearBallAndBat(leftBat, rightBat, ball);
            pingPongRules.moveBat(userInput, leftBat);
            pingPongRules.moveBall();
            if ( pingPongRules.pointScored(leftBat) || pingPongRules.pointScored(rightBat) ) {
                pingPongRules.updateScore();
                System.out.println("Ball is out: Score is " + score.getLeftBatScore() + ":" + score.getRightBatScore());
                pingPongRules.resetBallPositions();
                pingPongRules.resetLeftBatPosition();
                pingPongRules.resetRightBatPosition();
            }
            pingPongRules.changeBallDirection(leftBat, ball);
            pingPongRules.changeBallDirection(rightBat, ball);
            renderer.drawBallAndBats(leftBat, rightBat, ball, pingPongTable);
            System.out.println("Ball moved, Bat moved. What's your next move.\n w to go up, s to go down, q to quit");
            userInput = scanner.next().charAt(0);
        }
    }
}
