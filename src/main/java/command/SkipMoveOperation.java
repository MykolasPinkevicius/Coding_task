package command;

import game.PingPongRules;

public class SkipMoveOperation implements UserInputOperation {
    private PingPongRules pingPongRules;

    public SkipMoveOperation(PingPongRules pingPongRules) {
        this.pingPongRules = pingPongRules;
    }

    @Override
    public void execute() {
        pingPongRules.skipMove();
    }
}
