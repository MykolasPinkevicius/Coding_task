package command;

import game.MykolasPingPongRules;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Logger;

public class SaveGameOperation implements UserInputOperation {
    public static final String SAVED_GAME_FILE = "game.ser";
    private static final Logger logger = Logger.getLogger(SaveGameOperation.class.getName());
    private MykolasPingPongRules mykolasPingPongRules;

    public SaveGameOperation(MykolasPingPongRules mykolasPingPongRules) {
        this.mykolasPingPongRules = mykolasPingPongRules;
    }

    @Override
    public void execute(){
        try (FileOutputStream fileSave = new FileOutputStream(SAVED_GAME_FILE);
        ObjectOutputStream objectSaveToFile = new ObjectOutputStream(fileSave)) {
            objectSaveToFile.writeObject(mykolasPingPongRules);
            logger.info("Game saved in game.ser file");
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }
}
