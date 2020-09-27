package game;

import models.Ball;
import models.Bat;
import models.PingPongTable;
import models.ScoreBoard;

public interface PingPongRules {
    boolean pointScored(Bat bat);
    void updateScore();
    void moveBatUp();
    void moveBatDown();
    void returnLastGameData(MykolasPingPongRules pingPongRules);
    void skipMove();
    boolean someoneScored();
    void displayScore();
}
