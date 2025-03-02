package stratagies;

import models.Board;
import models.CellState;
import models.Move;

public class RowBasedWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();

        for (int col = 1; col < board.getDimension(); col++) {
            if (board.getCells().get(row).get(col).getCellState() == CellState.EMPTY) {
                return false;
            }
            if (board.getCells().get(row).get(col - 1).getCellState() == CellState.EMPTY) {
                return false;
            }

            if (!board.getCells().get(row).get(col).getPlayer().getSymbol().getSymbol().equalsIgnoreCase(
                    board.getCells().get(row).get(col - 1).getPlayer().getSymbol().getSymbol())) {
                return false;
            }
        }

        return true;
    }

}
