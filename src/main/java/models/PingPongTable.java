package models;

import java.io.Serializable;

public class PingPongTable implements Serializable {
    private static final int[][] tableSize = {
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
    };
    public boolean isBallEscaped(int x, int y) {
        return tableSize[x][y] == 2;
    }
    public boolean isBallBouncedToWall(int x, int y) {
        return tableSize[x][y] == 1;
    }
    public boolean isBatBumpToWall(int x, int y) {
        return tableSize[x][y] == 1;
    }

}
