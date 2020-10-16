package models;

import builder.MykolasPingPongRulesBuilder;
import command.CommandFactory;
import game.MykolasPingPongRules;
import render.Renderer;
import util.Utilities;

public class MykolasPingPongGame {
    private MykolasPingPongRules mykolasPingPongRules;
    private CommandFactory commandFactory;
    private Renderer renderer;

    public MykolasPingPongGame() {
        this.mykolasPingPongRules = initializeRules();
        this.commandFactory = initializeCommandFactory();
        this.renderer = initializeRenderer();
    }

    public MykolasPingPongRules getMykolasPingPongRules() {
        return mykolasPingPongRules;
    }

    public void setMykolasPingPongRules(MykolasPingPongRules mykolasPingPongRules) {
        this.mykolasPingPongRules = mykolasPingPongRules;
    }

    public CommandFactory getCommandFactory() {
        return commandFactory;
    }

    public void setCommandFactory(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
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

}
