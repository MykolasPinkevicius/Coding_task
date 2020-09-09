package util;

import Items.Coordinate;

import java.util.List;

public class Renderer {

    private char[][] tableOfCharacters = {
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
            {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
    };

    public void drawMap() {
        for (int row = 0; row < tableOfCharacters.length; row++) {
            for (int col = 0; col < tableOfCharacters[row].length; col++) {
                if (col < 1) {
                    System.out.print("\t" + tableOfCharacters[row][col]);
                } else {
                    System.out.print("\t" + tableOfCharacters[row][col]);
                }
            }
            System.out.println();
        }

    }
    public void drawItems(List<Coordinate> coordinates, char icon) {
        coordinates.forEach(coordinate -> tableOfCharacters[coordinate.getX()][coordinate.getY()] = icon);
    }

    public void clearScreen() {
        tableOfCharacters = new char[][] {
                {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
                {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
                {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
                {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
                {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
                {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
                {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
                {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
                {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
                {'e','e','e','e','e','e','e','e','e','e','e','e','e','e','e'},
        };
    }
}
