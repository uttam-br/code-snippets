package src;

import src.models.GameStatus;

public class Main {

    public static void main(String[] args) {

        TicTacToe ticTacToe = new TicTacToe(3, 3);

        ticTacToe.play();

        switch (ticTacToe.getGameStatus()) {
            case GameStatus.DRAW:
                System.out.println("Game Drawn !!!");
                break;
            case GameStatus.WINNER:
                System.out.println("Winner : " + ticTacToe.getWinner());
        }

    }

}
