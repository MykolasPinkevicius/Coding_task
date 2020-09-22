package render;


import java.util.List;

public class Renderer {
    public void drawMap(List<Drawable> drawables) {
        char[][] pingPongTableDimensions = new char[10][15];
        loadDrawables(drawables, pingPongTableDimensions);
        drawDrawables(pingPongTableDimensions);

    }

    private void drawDrawables(char[][] pingPongTableDimensions) {
        for (char[] pingPongTableDimension : pingPongTableDimensions) {
            for (char c : pingPongTableDimension) {
                System.out.print("\t" + c);
            }
            System.out.println();
        }
    }

    private void loadDrawables(List<Drawable> drawables, char[][] pingPongTableDimensions) {
        for (Drawable drawable:drawables) {
            for(int i = drawable.getStartingDrawingPointX();i <= drawable.getFinishingDrawingPointX();i++) {
                for (int j = drawable.getStartingDrawingPointY(); j <= drawable.getFinishingDrawingPointY(); j++) {
                   pingPongTableDimensions[i][j] = drawable.getIcon();
                }
            }
        }
    }
}
