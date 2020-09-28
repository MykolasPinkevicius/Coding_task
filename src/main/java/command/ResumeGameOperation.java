package command;

import game.MykolasPingPongRules;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Logger;

public class ResumeGameOperation implements UserInputOperation {
    public static final String SAVED_GAME_FILE = "game.ser";
    private static final Logger logger = Logger.getLogger(ResumeGameOperation.class.getName());
    private MykolasPingPongRules mykolasPingPongRules;

    public ResumeGameOperation(MykolasPingPongRules mykolasPingPongRules) {
        this.mykolasPingPongRules = mykolasPingPongRules;
    }

    @Override
    public void execute(){
        try (FileInputStream fileIn = new FileInputStream(SAVED_GAME_FILE);
        ObjectInputStream in = new ObjectInputStream(fileIn)) {
            MykolasPingPongRules lastGame = (MykolasPingPongRules) in.readObject();
            mykolasPingPongRules.returnLastGameData(lastGame);
        } catch (IOException | ClassNotFoundException e) {
            logger.info(e.getMessage());
        }
    }
}
