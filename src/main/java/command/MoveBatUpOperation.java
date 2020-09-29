package command;

import game.MykolasPingPongRules;


public class MoveBatUpOperation implements UserInputOperation {
    private MykolasPingPongRules mykolasPingPongRules;

    public MoveBatUpOperation(MykolasPingPongRules mykolasPingPongRules) {
        this.mykolasPingPongRules = mykolasPingPongRules;
    }

    @Override
    public void execute() {
        mykolasPingPongRules.activateMoveBatUp();
    }
}
