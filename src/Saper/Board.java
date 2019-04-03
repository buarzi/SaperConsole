package Saper;

import java.util.*;

public class Board {
    private static final int WIDTH = 8;
    private static final int HEIGHT = 8;
    private static final int BOMBS = 10;
    private static Random random = new Random();
    private static List<Point> bombsCoordinates = new ArrayList<>();
    private static int[][] boardGame = new int[WIDTH][HEIGHT];
    private static boolean WIN = true;
    private static int MOVES = 0;
    private static int BOMB_SIGN = 9;

    public Board() {
        createBombCoordinates();
        fillBoardWithBombs();
        //generateNonBombsNumbers();
        showMeWhereBombsAre();
        printBoard();
    }

    private List<Point> createBombCoordinates() {
        int counter = 0;
        do {
            int xCoordinates = 1 + random.nextInt(8);
            int yCoordinates = 1 + random.nextInt(8);
            Point tmpBombPoint = new Point(xCoordinates, yCoordinates);
            if (!bombsCoordinates.contains(tmpBombPoint)) {
                bombsCoordinates.add(tmpBombPoint);
                counter++;
            }
        } while (counter < BOMBS);
        return bombsCoordinates;
    }

    private void showMeWhereBombsAre() {
        System.out.println("Bombs coordinates: ");
        for (Point p : bombsCoordinates)
            System.out.print("[" + p.getX() + ", " + p.getY() + "]; ");
        System.out.println("\n");
    }

    private void fillBoardWithBombs() {
        for (Point p : bombsCoordinates) {
            boardGame[p.getX() - 1][p.getY() - 1] = 9;
        }
    }

    private void createNeighbourhood(Point p) {
        for (int i = p.getX() - 1; i <= p.getX(); i++) {
            for (int j = p.getY() - 1; j <= p.getY(); j++) {

            }
        }
    }

    private void fillBoardWithNoBombsNumbers() {
        for (Point p : bombsCoordinates) {

        }
    }

    public void printBoard() { //TODO: in one loop
        System.out.print(" | ");
        for (int i = 0; i < WIDTH; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        System.out.print("-- ");
        for (int i = 0; i < WIDTH; i++) {
            System.out.print("- ");
        }
        System.out.println();
        for (int i = 0; i < WIDTH; i++) {
            System.out.print((i + 1) + "| ");
            for (int j = 0; j < HEIGHT; j++) {
                System.out.print(boardGame[i][j] + " ");
            }
            System.out.println();
        }
    }
}
