package game;

import builder.MykolasPingPongRulesBuilder;
import command.CommandFactory;
import models.Ball;
import models.Bat;
import models.PingPongTable;
import models.ScoreBoard;
import render.Renderer;
import util.Utilities;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class StartGame {
    private static final Logger logger = Logger.getLogger(StartGame.class.getName());
    private static final char QUIT = 'q';

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {

        MykolasPingPongRules mykolasPingPongRules = initialiseRules();
        CommandFactory commandFactory = new CommandFactory();
        Renderer renderer = new Renderer();
        Scanner scanner = new Scanner(System.in);
        try (scanner) {
            startGameUntilQuited(mykolasPingPongRules, commandFactory, renderer, scanner);
        }
    }

    private static void startGameUntilQuited(MykolasPingPongRules mykolasPingPongRules, CommandFactory commandFactory, Renderer renderer, Scanner scanner) {
        char firstMoveInput = 'f';
        while (firstMoveInput != QUIT) {
            firstMoveInput = continueGame(commandFactory, renderer, scanner, mykolasPingPongRules);
        }
    }

    private static char getInput(Scanner scanner) {
        logger.info("Input 'w' to make bat go up, 's' to go down, 'f' to skip move, \n't' to save the game, 'r' to resume the last saved game, 'q' to quit game");
        return scanner.next().charAt(0);
    }

    private static void executeCommand(MykolasPingPongRules mykolasPingPongRules, CommandFactory commandFactory, char userInput) {
        try {
            commandFactory.getCommand(userInput, mykolasPingPongRules).execute();
        } catch (IllegalStateException e) {
            logger.info("we catched the wrong input \n you should choose from defined commands\n");
        }
    }

    private static void drawGame(MykolasPingPongRules mykolasPingPongRules, Renderer renderer) {
        renderer.drawMap(List.of(mykolasPingPongRules.getLeftBat(), mykolasPingPongRules.getRightBat(), mykolasPingPongRules.getBall()));
    }

    private static char continueGame(CommandFactory commandFactory, Renderer renderer, Scanner scanner, MykolasPingPongRules mykolasPingPongRules){
        drawGame(mykolasPingPongRules, renderer);
        char userInput = getInput(scanner);
        executeCommand(mykolasPingPongRules, commandFactory, userInput);
        return userInput;
    }

    private static MykolasPingPongRules initialiseRules() {
        return new MykolasPingPongRulesBuilder()
                .setLeftBat(new Bat(4, 5, 6, 1))
                .setRightBat(new Bat(4, 5, 6, 13))
                .setBall(new Ball(5, 7, Utilities.getRandomNumberForDirection(), Utilities.getRandomNumberForVerticalDirection()))
                .setScoreBoard(new ScoreBoard())
                .setPingPongTable(new PingPongTable())
                .build();
    }
}
