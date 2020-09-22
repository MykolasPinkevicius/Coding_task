package command;

import game.PingPongRules;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveGameOperation implements UserInputOperation {
    public static final String SAVED_GAME_FILE = "game.ser";
    private PingPongRules pingPongRules;

    public SaveGameOperation(PingPongRules pingPongRules) {
        this.pingPongRules = pingPongRules;
    }

    @Override
    public void execute() throws IOException {
        FileOutputStream fileOut = new FileOutputStream(SAVED_GAME_FILE);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(pingPongRules);
        out.close();
        fileOut.close();
        System.out.println("Game saved in game.ser file");
    }
}
