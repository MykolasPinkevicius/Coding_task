package game;

import Items.Ball;
import Items.Bat;
import Items.PingPongTable;
import Items.ScoreBoard;
import builder.PingPongRulesImplBuilder;
import command.CommandFactory;
import util.Renderer;
import util.Utilities;

import java.io.IOException;
import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final char QUIT = 'q';

        CommandFactory commandFactory = new CommandFactory();
        Renderer renderer = new Renderer();
        Scanner scanner = new Scanner(System.in);
        PingPongRules pingPongRules = new PingPongRulesImplBuilder()
                .setLeftBat(new Bat(4, 5, 6, 1))
                .setRightBat(new Bat(4, 5, 6, 13))
                .setBall(new Ball(5, 7, Utilities.getRandomNumberForDirection(), Ball.STRAIGHT_DIRECTION))
                .setScoreBoard(new ScoreBoard())
                .setPingPongTable(new PingPongTable())
                .build();
        renderer.drawItems(Utilities.inputCoordinatesFromObject(pingPongRules.getLeftBat()), Bat.BALL_ICON);
        renderer.drawItems(Utilities.inputCoordinatesFromObject(pingPongRules.getRightBat()), Bat.BALL_ICON);
        renderer.drawItems(Utilities.inputCoordinatesFromObject(pingPongRules.getBall()), Ball.BALL_ICON);
        renderer.drawMap();

        System.out.println("Input 'w' to make bat go up, 's' to go down, 'f' to skip move, \n't' to save the game, 'r' to resume the last saved game, 'q' to quit game");
        char userInput = scanner.next().charAt(0);
        commandFactory.getCommand(userInput, pingPongRules).execute();

        while (userInput != QUIT) {
            renderer.clearScreen();
            renderer.drawItems(Utilities.inputCoordinatesFromObject(pingPongRules.getLeftBat()), Bat.BALL_ICON);
            renderer.drawItems(Utilities.inputCoordinatesFromObject(pingPongRules.getRightBat()), Bat.BALL_ICON);
            renderer.drawItems(Utilities.inputCoordinatesFromObject(pingPongRules.getBall()), Ball.BALL_ICON);
            renderer.drawMap();
            System.out.println("Input 'w' to make bat go up, 's' to go down, 'f' to skip move, \n't' to save the game, 'r' to resume the last saved game, 'q' to quit game");
            userInput = scanner.next().charAt(0);
            commandFactory.getCommand(userInput, pingPongRules).execute();
        }
        scanner.close();
    }
}
