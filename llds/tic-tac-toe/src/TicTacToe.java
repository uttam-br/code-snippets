package src;

import src.models.*;
import src.strategies.gameplayerstrategies.CPUGamePlayingStrategy;
import src.strategies.gameplayerstrategies.HumanGamePlayingStrategy;

import java.util.List;

public class TicTacToe {

    private GameStatus gameStatus;
    private Player winner;
    private List<Player> players;
    private Board board;
    private Player currentPlayer;
    private List<Move> moves;

    public TicTacToe(int rows, int columns) {
        // initialize board
        this.board = new Board(rows, columns);

        // players
        Player humanPlayer = new Player(Symbol.X, new HumanGamePlayingStrategy());
        Player cpuPlayer = new Player(Symbol.O, new CPUGamePlayingStrategy());
    }


    public void play() {


    }


    //    Getters
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

}
