package command;

import game.PingPongRules;

public class CommandFactory {
    public UserInputOperation getCommand(char userInput, PingPongRules pingPongRules) {
        switch(userInput) {
            case 'w':
                return new MoveBatUpOperation(pingPongRules);
            case 's':
                return new MoveBatDownOperation(pingPongRules);
            case 'q':
                return new QuitGameOperation();
            case 't':
                return new SaveGameOperation(pingPongRules);
            case 'r':
                return new ResumeGameOperation(pingPongRules);
            case 'f':
                return new SkipMoveOperation(pingPongRules);
        }
        return new DefaultCommandOperation();
    }
}
