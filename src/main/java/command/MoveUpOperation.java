package command;

import game.MykolasPingPongRules;


public class MoveUpOperation implements UserInputOperation {
    private MykolasPingPongRules mykolasPingPongRules;

    public MoveUpOperation(MykolasPingPongRules mykolasPingPongRules) {
        this.mykolasPingPongRules = mykolasPingPongRules;
    }

    @Override
    public void execute() {
        mykolasPingPongRules.activateMoveUp();
    }
}
