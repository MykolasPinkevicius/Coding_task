package command;


public class DefaultCommandOperation implements UserInputOperation {
    @Override
    public void execute() {
        System.out.println("Your Input didn't fit. Please follow the rules.");
    }
}
