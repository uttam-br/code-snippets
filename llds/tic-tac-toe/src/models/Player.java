package src.models;

import src.strategies.gameplayerstrategies.GamePlayingStrategy;

public class Player {

    private Symbol symbol;
    private GamePlayingStrategy gamePlayingStrategy;

    public Player(Symbol symbol, GamePlayingStrategy gamePlayingStrategy) {
        this.symbol = symbol;
        this.gamePlayingStrategy = gamePlayingStrategy;
    }

}
