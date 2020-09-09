package command;

import reciever.UserInput;

public class GetInputCharOperation implements UserInputOperation {
    private UserInput userInput;

    public GetInputCharOperation(UserInput userInput) {
        this.userInput = userInput;
    }

    @Override
    public char execute() {
        return userInput.getInput();
    }
}
