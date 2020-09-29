package game;

import models.Bat;


public interface PingPongRules {
    boolean pointScored(Bat bat);
    void updateScore();
    void activateMoveBatUp();
    void activateMoveBatDown();
    void returnLastGameData(MykolasPingPongRules pingPongRules);
    void skipMove();
    boolean someoneScored();
    void displayScore();
}
