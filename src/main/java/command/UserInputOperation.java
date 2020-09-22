package command;

import java.io.IOException;

@FunctionalInterface
public interface UserInputOperation {
        void execute() throws IOException, ClassNotFoundException;
}
