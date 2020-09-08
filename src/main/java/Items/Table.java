package Items;

public class Table {
    private static int[][] tableSize = {
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
    };

    public int getHeight() {
        return tableSize[0].length;
    }
    public int getWidth() {
        return tableSize.length;
    }
    public boolean isBallEscaped(int x, int y) {
        return tableSize[x][y] == 2;
    }
    public boolean isBallBounced(int x, int y) {
        return tableSize[x][y] == 1;
    }

}
