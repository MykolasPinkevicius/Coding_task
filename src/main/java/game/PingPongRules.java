package game;

import models.Bat;


public interface PingPongRules {
    boolean pointScored(Bat bat);
    void updateScore();
    void activateMoveUp();
    void activateMoveDown();
    void returnLastGameData(MykolasPingPongRules pingPongRules);
    void skipMove();
    boolean someoneScored();
    void displayScore();
}
