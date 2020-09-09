package command;

import game.PingPongRules;

public class MoveOperation implements UserInputOperation {
    private char userInput;
    private PingPongRules pingPongRules;

    public MoveOperation(char userInput, PingPongRules pingPongRules) {
        this.userInput = userInput;
        this.pingPongRules = pingPongRules;
    }

    @Override
    public void execute() {
        pingPongRules.moveBall();
        pingPongRules.moveBat(userInput);
        pingPongRules.changeBallDirection();
    }
}
