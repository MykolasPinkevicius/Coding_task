package game;

import builder.MykolasPingPongRulesBuilder;
import command.CommandFactory;
import models.Ball;
import models.Bat;
import models.PingPongTable;
import models.ScoreBoard;
import render.Renderer;
import util.Utilities;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final char QUIT = 'q';
        CommandFactory commandFactory = new CommandFactory();
        Renderer renderer = new Renderer();
        Scanner scanner = new Scanner(System.in);
        MykolasPingPongRules mykolasPingPongRules = new MykolasPingPongRulesBuilder()
                .setLeftBat(new Bat(4, 5, 6, 1))
                .setRightBat(new Bat(4, 5, 6, 13))
                .setBall(new Ball(5, 7, Utilities.getRandomNumberForDirection(), Utilities.getRandomNumberForVerticalDirection()))
                .setScoreBoard(new ScoreBoard())
                .setPingPongTable(new PingPongTable())
                .build();
        renderer.drawMap(List.of(mykolasPingPongRules.getLeftBat(), mykolasPingPongRules.getRightBat(), mykolasPingPongRules.getBall()));

        System.out.println("Input 'w' to make bat go up, 's' to go down, 'f' to skip move, \n't' to save the game, 'r' to resume the last saved game, 'q' to quit game");
        char userInput = scanner.next().charAt(0);
        commandFactory.getCommand(userInput, mykolasPingPongRules).execute();

        while (userInput != QUIT) {
            renderer.drawMap(List.of(mykolasPingPongRules.getLeftBat(), mykolasPingPongRules.getRightBat(), mykolasPingPongRules.getBall()));
            System.out.println("Input 'w' to make bat go up, 's' to go down, 'f' to skip move, \n't' to save the game, 'r' to resume the last saved game, 'q' to quit game");
            userInput = scanner.next().charAt(0);
            commandFactory.getCommand(userInput, mykolasPingPongRules).execute();
        }
        scanner.close();
    }
}
