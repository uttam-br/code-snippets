import models.GameState;
import models.TicTacToe;

public class Main {

    public static void main(String[] args) {

        System.out.println("----- Tic Tac Toe -----");

        TicTacToe ticTacToe = new TicTacToe();

        ticTacToe.startGame();

        if (ticTacToe.getGameState() == GameState.ENDED) {
            System.out.println(ticTacToe.getWinner().getName() + " won the game");
        } else {
            System.out.println("Game Drawn");
        }

    }

}

