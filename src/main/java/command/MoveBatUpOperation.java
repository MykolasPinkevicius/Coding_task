package command;

import game.PingPongRules;


public class MoveBatUpOperation implements UserInputOperation {
    private PingPongRules pingPongRules;

    public MoveBatUpOperation(PingPongRules pingPongRules) {
        this.pingPongRules = pingPongRules;
    }

    @Override
    public void execute() {
        pingPongRules.moveBatUp();
    }
}
