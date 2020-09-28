package command;

import java.util.logging.Logger;

public class QuitGameOperation implements UserInputOperation {
    private static final Logger logger = Logger.getLogger(QuitGameOperation.class.getName());

    @Override
    public void execute() {
        logger.info("\n Game over. You quitted the game");
    }
}
