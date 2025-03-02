package models;

import helper.InputProcessor;

public class HumanPlayer implements Player {

    private String name;
    private Symbol symbol;

    public HumanPlayer(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Move makeMove() {
        System.out.println("Turn - " + this.getName() + " ( " + this.getSymbol().getSymbol() + ")");

        int i = InputProcessor.readInt("Enter row : ");
        int j = InputProcessor.readInt("Enter col : ");

        return new Move(this, new Cell(i, j));
    }

}
