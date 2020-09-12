package command;

import game.PingPongRules;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveGameOperation implements UserInputOperation {
    private PingPongRules pingPongRules;

    public SaveGameOperation(PingPongRules pingPongRules) {
        this.pingPongRules = pingPongRules;
    }

    @Override
    public void execute() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("game.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(pingPongRules);
        out.close();
        fileOut.close();
        System.out.println("Game saved in game.ser file");
    }
}
