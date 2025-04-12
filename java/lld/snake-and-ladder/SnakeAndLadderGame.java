import models.Cell;
import models.Move;
import models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeAndLadderGame {

    Scanner sc = new Scanner(System.in);

    List<Player> players = new ArrayList<>();

    Player currentPlayer = null;

    Player winner;

    public void startGame() {
        // take players input
        Player player01 = new Player("01", "Yellow", new Cell(0, 0));
        Player player02 = new Player("02", "Red", new Cell(0, 0));

        players.add(player01);
        players.add(player02);

        currentPlayer = player01;

        while (true) {
            // if anyone is on 100th cell, then game ends.
            for (Player player: players) {
                if (player.getCurrentPosition().getRow() == 99 && player.getCurrentPosition().getColumn() == 99) {
                    winner = player;
                    return;
                }
            }

            // ask current player to make move
            Move move = promptPlayerForMove();

            // validate move

            // make move

            // update current player

        }

    }

    private Move promptPlayerForMove() {
        Move move = new Move();

        System.out.println("Enter Destination - i : ");
        int i = sc.nextInt();

        System.out.println("Enter Destination - j : ");
        int j = sc.nextInt();

        move.setToCell(new Cell(i, j));
        
        return move;
    }

}
