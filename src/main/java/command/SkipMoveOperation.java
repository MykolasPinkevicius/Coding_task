package command;

import game.MykolasPingPongRules;

public class SkipMoveOperation implements UserInputOperation {
    private MykolasPingPongRules mykolasPingPongRules;

    public SkipMoveOperation(MykolasPingPongRules mykolasPingPongRules) {
        this.mykolasPingPongRules = mykolasPingPongRules;
    }

    @Override
    public void execute() {
        mykolasPingPongRules.skipMove();
    }
}
