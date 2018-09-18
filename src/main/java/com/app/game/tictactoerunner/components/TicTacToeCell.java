package com.app.game.tictactoerunner.components;

import com.app.game.tictactoerunner.player.Player;

/**
 * Created by AKHIL-JARVIS on 10-09-2018.
 */
public class TicTacToeCell {

    public Player content;

    int row, col;

    public TicTacToeCell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void paint() {
        //if player is present
        if(content != null)
            System.out.print(content.getSymbol());
        else
            System.out.print(" ");
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
