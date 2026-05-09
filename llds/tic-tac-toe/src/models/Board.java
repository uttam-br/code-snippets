package src.models;

public class Board {

    private int rows;
    private int columns;

    private Symbol[][] cells;

    public Board(int rows, int columns) {
        cells = new Symbol[rows][columns];
    }


}
