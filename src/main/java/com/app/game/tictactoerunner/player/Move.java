package com.app.game.tictactoerunner.player;

public class Move {
    private int row;
    private int col;

    public Move(int x, int col) {
        this.row = x;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isInValidRange(int size) {
        return row < size && col < size;
    }
}