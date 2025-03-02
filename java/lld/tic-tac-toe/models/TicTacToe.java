package models;

import exceptions.InvalidMoveException;
import helper.InputProcessor;
import stratagies.ColBasedWinningStrategy;
import stratagies.RowBasedWinningStrategy;
import stratagies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private List<WinningStrategy> winningStrategies;
    private Player winner;
    private int currentPlayerIndex;

    public TicTacToe() {
        this.players = new ArrayList<>();
        this.gameState = GameState.READY;
        this.moves = new ArrayList<>();
        this.winningStrategies = List.of(new RowBasedWinningStrategy(), new ColBasedWinningStrategy());
        this.currentPlayerIndex = 0;
    }

    public void startGame() {
        // ask for inputs
        int numberOfPlayers = InputProcessor.readInt("Enter number of players");
        System.out.println("Please enter symbol for each player");

        // players
        for (int i = 0; i < numberOfPlayers; i++) {
            String nameInput = InputProcessor.readString("Enter name : ");
            String symbolInput = InputProcessor.readString("Enter symbol : ");
            Symbol symbol = new Symbol(symbolInput);
            Player player = new HumanPlayer(nameInput, symbol);
            players.add(player);
        }

        // bot player

        // dimension
        int dimension = InputProcessor.readInt("Dimension of game : ");
        this.board = new Board(dimension);

        gameState = GameState.RUNNING;

        while (gameState == GameState.RUNNING) {
            // display board
            board.display();

            // ask player to make move
            Player currentPlayer = players.get(currentPlayerIndex);

            Move proposedMove = currentPlayer.makeMove();

            // validate move
            try {
                board.validateMove(proposedMove);
            } catch (InvalidMoveException invalidMoveException) {
                System.out.println(invalidMoveException.getMessage());
                continue;
            }

            // make move
            board.makeMove(proposedMove);

            // check if any winner
            for (WinningStrategy winningStrategy : winningStrategies) {
                if (winningStrategy.checkWinner(board, proposedMove)) {
                    winner = currentPlayer;
                    gameState = GameState.ENDED;
                }
            }

            // check if draw
            if (moves.size() == dimension * dimension) {
                // exhausted all moves hence draw
                gameState = GameState.DRAW;
            }

            // update player's turn
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

        board.display();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getWinner() {
        return this.winner;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }
}
