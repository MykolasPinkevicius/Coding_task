package command;

import game.MykolasPingPongRules;


public class MoveDownOperation implements UserInputOperation {
    private MykolasPingPongRules mykolasPingPongRules;

    public MoveDownOperation(MykolasPingPongRules mykolasPingPongRules) {
        this.mykolasPingPongRules = mykolasPingPongRules;
    }

    @Override
    public void execute() {
        mykolasPingPongRules.activateMoveDown();
    }
}
