package models;

import exceptions.InvalidMoveException;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int dimension;
    private List<List<Cell>> cells;

    public Board(int dimension) {
        this.dimension = dimension;
        this.cells = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < dimension; j++) {
                row.add(new Cell(i, j));
            }
            this.cells.add(row);
        }
    }

    public void display() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                cells.get(i).get(j).display();
            }
            System.out.println();
        }
    }

    public void validateMove(Move move) throws InvalidMoveException {
        Cell cell = move.getCell();
        int i = cell.getRow();
        int j = cell.getCol();

        if (i < 0 || j < 0 || i >= cells.size() || j >= cells.get(0).size()) {
            throw new InvalidMoveException("Invalid indexes");
        }

        if (cells.get(i).get(j).getCellState() != CellState.EMPTY) {
            throw new InvalidMoveException("Cell is already filled");
        }
    }

    public void makeMove(Move move) {
        int i = move.getCell().getRow();
        int j = move.getCell().getCol();

        Player player = move.getPlayer();

        cells.get(i).get(j).setPlayer(player);
        cells.get(i).get(j).setCellState(CellState.FILLED);
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

}
