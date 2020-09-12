package command;

import java.io.FileNotFoundException;
import java.io.IOException;

@FunctionalInterface
public interface UserInputOperation {
        void execute() throws IOException, ClassNotFoundException;
}
