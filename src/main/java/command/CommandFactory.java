package command;

import game.MykolasPingPongRules;

public class CommandFactory {
    public UserInputOperation getCommand(char userInput, MykolasPingPongRules mykolasPingPongRules) {
        switch (userInput) {
            case 'w':
                return new MoveUpOperation(mykolasPingPongRules);
            case 's':
                return new MoveDownOperation(mykolasPingPongRules);
            case 'q':
                return new QuitGameOperation();
            case 't':
                return new SaveGameOperation(mykolasPingPongRules);
            case 'r':
                return new ResumeGameOperation(mykolasPingPongRules);
            case 'f':
                return new SkipMoveOperation(mykolasPingPongRules);
            default:
                throw new IllegalStateException("Unexpected value: " + userInput + " you should choose from defined commands");
        }
    }
}
