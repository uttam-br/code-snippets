package src.strategies.gameplayerstrategies;

import src.models.Board;
import src.models.Move;

public interface GamePlayingStrategy {

    Move makeMove(Board board);

}
