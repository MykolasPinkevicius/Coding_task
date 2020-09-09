package command;

public class QuitGameOperation implements UserInputOperation {

    @Override
    public void execute() {
        System.out.println("\n Game over. You quitted the game");
    }
}
