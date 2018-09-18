package com.app.game.tictactoerunner.config;

public class GameConfiguration {
    private int size;
    private String symbolOne;
    private String symbolTwo;
    private String computerSymbol;

    GameConfiguration(int size, String symbolOne, String symbolTwo, String computerSymbol) {
        this.size = size;
        this.symbolOne = symbolOne;
        this.symbolTwo = symbolTwo;
        this.computerSymbol = computerSymbol;
    }

    public int getSize() {
        return size;
    }

    public String getSymbolOne() {
        return symbolOne;
    }

    public String getSymbolTwo() {
        return symbolTwo;
    }

    public String getComputerSymbol() {
        return computerSymbol;
    }
}
