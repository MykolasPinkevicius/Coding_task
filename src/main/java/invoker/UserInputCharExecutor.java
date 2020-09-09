package invoker;

import command.UserInputOperation;

import java.util.ArrayList;
import java.util.List;

public class UserInputCharExecutor {
    private final List<UserInputOperation> userInputOperations
            = new ArrayList<>();

    public char executeOperation(UserInputOperation userInputOperation) {
        userInputOperations.add(userInputOperation);
        return userInputOperation.execute();
    }
}
