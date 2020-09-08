package game;

public interface GameRules {
    boolean pointScored();
    boolean changeBallDirection();
    void resetPositions();
    void updateScore();
    void moveBat(char direction);
}
