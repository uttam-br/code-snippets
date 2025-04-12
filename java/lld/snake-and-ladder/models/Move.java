package models;

public class Move {

    Cell fromCell;
    Cell toCell;

    public Cell getFromCell() {
        return fromCell;
    }

    public void setFromCell(Cell fromCell) {
        this.fromCell = fromCell;
    }

    public Cell getToCell() {
        return toCell;
    }

    public void setToCell(Cell toCell) {
        this.toCell = toCell;
    }
}
