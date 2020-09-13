package command;

import game.PingPongRules;

public class SkipMoveOperation implements UserInputOperation {
    private PingPongRules pingPongRules;

    public SkipMoveOperation(PingPongRules pingPongRules) {
        this.pingPongRules = pingPongRules;
    }

    @Override
    public void execute() {
        pingPongRules.moveBall();
        pingPongRules.changeBallDirection();
        pingPongRules.moveNPCBat();
        if (pingPongRules.someoneScored()) {
            pingPongRules.updateScore();
            pingPongRules.displayScore();
            pingPongRules.resetBallPositions();
            pingPongRules.resetLeftBatPosition();
            pingPongRules.resetRightBatPosition();
        }
    }
}
