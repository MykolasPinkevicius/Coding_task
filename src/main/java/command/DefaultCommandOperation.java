package command;

import java.io.IOException;

public class DefaultCommandOperation implements UserInputOperation {
    @Override
    public void execute() throws IOException, ClassNotFoundException {
        System.out.println("Your Input didn't fit. Please follow the rules.");
    }
}
