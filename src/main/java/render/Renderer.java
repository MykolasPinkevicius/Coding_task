package render;

import models.Coordinate;

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
        for (char[] tableOfCharacter : tableOfCharacters) {
            for (char c : tableOfCharacter) {
                System.out.print("\t" + c);
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
