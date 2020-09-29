package command;

import game.MykolasPingPongRules;


public class MoveBatDownOperation implements UserInputOperation {
    private MykolasPingPongRules mykolasPingPongRules;

    public MoveBatDownOperation(MykolasPingPongRules mykolasPingPongRules) {
        this.mykolasPingPongRules = mykolasPingPongRules;
    }

    @Override
    public void execute() {
        mykolasPingPongRules.activateMoveBatDown();
    }
}
