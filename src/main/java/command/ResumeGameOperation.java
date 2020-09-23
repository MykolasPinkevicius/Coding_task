package command;

import game.PingPongRules;
import game.PingPongRulesImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ResumeGameOperation implements UserInputOperation {
    public static final String SAVED_GAME_FILE = "game.ser";
    private PingPongRules pingPongRules;

    public ResumeGameOperation(PingPongRules pingPongRules) {
        this.pingPongRules = pingPongRules;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(SAVED_GAME_FILE);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        PingPongRulesImpl lastGame = (PingPongRulesImpl) in.readObject();
        pingPongRules.returnLastGameData(lastGame);
        in.close();
        fileIn.close();
    }
}
