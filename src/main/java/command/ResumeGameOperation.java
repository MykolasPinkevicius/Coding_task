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
        try (FileInputStream fileOpen = new FileInputStream(SAVED_GAME_FILE);
        ObjectInputStream objectOpenFromFile = new ObjectInputStream(fileOpen)) {
            MykolasPingPongRules lastGame = (MykolasPingPongRules) objectOpenFromFile.readObject();
            mykolasPingPongRules.returnLastGameData(lastGame);
        } catch (IOException | ClassNotFoundException e) {
            logger.info(e.getMessage());
        }
    }
}
