package com.app.game.tictactoerunner.player;


public abstract class Player {
    private String symbol;
    private String name;

    public Player(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public abstract Move nextMove();
}