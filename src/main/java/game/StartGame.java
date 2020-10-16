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
    public static final char FIRST_MOVE = 'f';

    public static void main(String[] args) {
        initializeGame();
    }

    public static void initializeGame() {
        char move = FIRST_MOVE;
        MykolasPingPongRules mykolasPingPongRules = initializeRules();
        Renderer renderer = initializeRenderer();
        Scanner scanner = initializeScanner();
        CommandFactory commandFactory = initializeCommandFactory();
        try (scanner) {
            while (move != QUIT) {
                move = startGame(commandFactory, renderer, scanner, mykolasPingPongRules);
            }
        }
    }

    private static char startGame(CommandFactory commandFactory, Renderer renderer, Scanner scanner, MykolasPingPongRules mykolasPingPongRules) {
        drawGame(mykolasPingPongRules, renderer);
        char userInput = getInput(scanner);
        executeCommand(mykolasPingPongRules, commandFactory, userInput);
        return userInput;
    }

    private static void drawGame(MykolasPingPongRules mykolasPingPongRules, Renderer renderer) {
        renderer.drawMap(List.of(mykolasPingPongRules.getLeftBat(), mykolasPingPongRules.getRightBat(), mykolasPingPongRules.getBall()));
    }

    private static char getInput(Scanner scanner) {
        logger.info("Input 'w' to make bat go up, 's' to go down, 'f' to skip move, \n't' to save the game, 'r' to resume the last saved game, 'q' to quit game");
        return scanner.next().charAt(0);
    }

    private static void executeCommand(MykolasPingPongRules mykolasPingPongRules, CommandFactory commandFactory, char userInput) {
        try {
            commandFactory.getCommand(userInput, mykolasPingPongRules).execute();
        } catch (IllegalStateException e) {
            logger.info("we caught the wrong input \n you should choose from defined commands\n");
        }
    }

    private static MykolasPingPongRules initializeRules() {
        return new MykolasPingPongRulesBuilder()
                .setLeftBat(new Bat(4, 5, 6, 1))
                .setRightBat(new Bat(4, 5, 6, 13))
                .setBall(new Ball(5, 7, Utilities.getRandomNumberForHorizontalDirection(), Utilities.getRandomNumberForVerticalDirection()))
                .setScoreBoard(new ScoreBoard())
                .setPingPongTable(new PingPongTable())
                .build();
    }

    private static CommandFactory initializeCommandFactory() {
        return new CommandFactory();
    }

    private static Renderer initializeRenderer() {
        return new Renderer();
    }

    private static Scanner initializeScanner() {
        return new Scanner(System.in);
    }
}
