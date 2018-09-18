package com.app.game.tictactoerunner.components;

import com.app.game.tictactoerunner.player.Move;
import com.app.game.tictactoerunner.player.Player;

/**
 * Created by AKHIL-JARVIS on 10-09-2018.
 */
public class TicTacToeBoard {


    private int size;

    public TicTacToeCell[][] ticTacToeCells;

    public int currentRow, currentCol;

    private GameState currentState;

    public TicTacToeBoard(int size){
        this.size = size;
        ticTacToeCells = new TicTacToeCell[size][size];  // allocate the array
        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                ticTacToeCells[row][col] = new TicTacToeCell(row, col); // allocate element of the array
            }
        }
    }

    //getter
    public int getSize() {
        return size;
    }

    public boolean isDraw() {
        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                if (ticTacToeCells[row][col].content == null) {
                    return false; // an empty seed found, not a draw, exit
                }
            }
        }
        return true; // no empty cell, it's a draw
    }

    public GameState playerMove(Player player) {
        int row= 0;
        int col = 0;
            Move move = player.nextMove();
            if (move.getRow() >= 0 && move.getRow() < this.getSize() && move.getCol() >= 0 && move.getCol() < this.getSize()
                    && this.ticTacToeCells[move.getRow()][move.getCol()].content == null) {
                this.ticTacToeCells[move.getRow()][move.getCol()].content = player;
                this.currentRow = row;
                this.currentCol = col;
                if (this.hasWon(player)) {
                    currentState = GameState.WON;
                } else if (this.isDraw()) {
                    // check for draw
                    currentState = GameState.DRAW;
                } else {
                    currentState = GameState.PLAYING;
                }
            } else {
                System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                        + ") is not valid. Try again...");
                currentState = GameState.RETRY;
            }
        return currentState;
    }


    public boolean hasWon(Player player) {
        return isWinner(currentRow,currentCol, player);
    }

    public boolean isWinner(int row, int col, Player player){
        int r = row;
        int c = col;

        boolean onDiagonal = (row == col) || (col == -1 * row + (ticTacToeCells.length-1));
        boolean HorizontalWin = true, VerticalWin = true;
        boolean DiagonalWinOne = true, DiagonalWinTwo = true;

        // Check the rows and columns
        for(int n = 0; n < ticTacToeCells.length; n++){
            if(ticTacToeCells[r][n].content != player)
                HorizontalWin = false;
            if(ticTacToeCells[n][c].content != player)
                VerticalWin = false;
        }

        // Only check diagonals if the move is on a diagonal
        if(onDiagonal){
            // Check the diagonals
            for(int n = 0; n < ticTacToeCells.length; n++){
                if(ticTacToeCells[n][n].content != player)
                    DiagonalWinOne = false;
                if(ticTacToeCells[n][-1*n+(ticTacToeCells.length-1)].content != player)
                    DiagonalWinTwo = false;
            }
        }
        else{
            DiagonalWinOne = false;
            DiagonalWinTwo = false;
        }

        boolean hasWon = (HorizontalWin || VerticalWin || DiagonalWinOne || DiagonalWinTwo);
        return hasWon;

    }


    public void paint() {
        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                ticTacToeCells[row][col].paint();   // each cell paints itself
                if (col < size - 1) System.out.print("|");
            }
            System.out.println();
        }
    }
}
