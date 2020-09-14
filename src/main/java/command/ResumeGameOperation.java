package command;

import game.PingPongRules;
import game.PingPongRulesImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ResumeGameOperation implements UserInputOperation {
    private PingPongRules pingPongRules;

    public ResumeGameOperation(PingPongRules pingPongRules) {
        this.pingPongRules = pingPongRules;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("game.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        PingPongRulesImpl lastGame = (PingPongRulesImpl) in.readObject();
        pingPongRules.setBall(lastGame.getBall());
        pingPongRules.setLeftBat(lastGame.getLeftBat());
        pingPongRules.setRightBat(lastGame.getRightBat());
        pingPongRules.setPingPongTable(lastGame.getPingPongTable());
        pingPongRules.setScoreBoard(lastGame.getScoreBoard());
        System.out.println("You resumed your last game");
        pingPongRules.displayScore();
        in.close();
        fileIn.close();
    }
}
