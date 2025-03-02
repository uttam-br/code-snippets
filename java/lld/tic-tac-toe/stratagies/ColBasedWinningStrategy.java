package stratagies;

import models.Board;
import models.CellState;
import models.Move;

public class ColBasedWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();

        for (int row = 1; row < board.getDimension(); row++) {

            if (board.getCells().get(row).get(col).getCellState() == CellState.EMPTY) {
                return false;
            }

            if (board.getCells().get(row - 1).get(col).getCellState() == CellState.EMPTY) {
                return false;
            }

            if (!board.getCells().get(row).get(col).getPlayer().getSymbol().getSymbol().equalsIgnoreCase(
                    board.getCells().get(row - 1).get(col).getPlayer().getSymbol().getSymbol()
            )) {
                return false;
            }
        }

        return true;
    }

}
