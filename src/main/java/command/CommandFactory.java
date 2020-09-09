package command;

import game.PingPongRules;

public class CommandFactory {
    public UserInputOperation getCommand(char userInput, PingPongRules pingPongRules) {
        if ('w' == userInput || 's' == userInput) {
            return new MoveOperation(userInput, pingPongRules);
        } else if ('q' == userInput) {
            return new QuitGameOperation();
        } else {
            System.out.println("Please choose correct command\nw to go up, s to go down, q too legit to quit");
        }
        return null;
    }
}
