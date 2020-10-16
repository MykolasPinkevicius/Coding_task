package game;

import models.MykolasPingPongGame;

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
        Scanner scanner = initializeScanner();
        MykolasPingPongGame mykolasPingPongGame = new MykolasPingPongGame();
        try (scanner) {
            while (move != QUIT) {
                move = startGame(mykolasPingPongGame, scanner);
            }
        }
    }

    private static char startGame(MykolasPingPongGame game, Scanner scanner) {
        drawGame(game);
        char userInput = getInput(scanner);
        executeCommand(game, userInput);
        return userInput;
    }

    private static void drawGame(MykolasPingPongGame game) {
        game.getRenderer().drawMap(List.of(game.getMykolasPingPongRules().getLeftBat(), game.getMykolasPingPongRules().getRightBat(), game.getMykolasPingPongRules().getBall()));
    }

    private static char getInput(Scanner scanner) {
        logger.info("Input 'w' to make bat go up, 's' to go down, 'f' to skip move, \n't' to save the game, 'r' to resume the last saved game, 'q' to quit game");
        return scanner.next().charAt(0);
    }

    private static void executeCommand(MykolasPingPongGame game, char userInput) {
        try {
            game.getCommandFactory().getCommand(userInput, game.getMykolasPingPongRules()).execute();
        } catch (IllegalStateException e) {
            logger.info("we caught the wrong input \n you should choose from defined commands\n");
        }
    }

    private static Scanner initializeScanner() {
        return new Scanner(System.in);
    }
}
