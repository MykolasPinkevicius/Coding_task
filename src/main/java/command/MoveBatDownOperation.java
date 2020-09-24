package command;

import game.PingPongRules;


public class MoveBatDownOperation implements UserInputOperation {
    private PingPongRules pingPongRules;

    public MoveBatDownOperation(PingPongRules pingPongRules) {
        this.pingPongRules = pingPongRules;
    }

    @Override
    public void execute() {
        pingPongRules.moveBatDown();
    }
}
