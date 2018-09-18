package com.app.game.tictactoerunner.player;


import com.app.game.tictactoerunner.components.TicTacToeBoard;

import java.util.Random;

public class ComputerPlayer extends Player {
    private final TicTacToeBoard ticTacToeBoard;

    public ComputerPlayer(String symbol, String name,
                          TicTacToeBoard ticTacToeBoard) {
        super(symbol, name);
        this.ticTacToeBoard = ticTacToeBoard;
    }

    @Override
    public Move nextMove() {
        System.out.println(this.getName()+" is thinking of a good Move. Its a tough game !");
        for (int i = 0; i < ticTacToeBoard.ticTacToeCells.length; i++) {
            for (int j = 0; j < ticTacToeBoard.ticTacToeCells.length; j++) {
                if (ticTacToeBoard.ticTacToeCells[i][j].content == null) {
                    boolean winner = ticTacToeBoard.isWinner(i, j, this);
                    if (winner)
                        return new Move(i,j);
                    else
                        continue;
                }
            }
        }
        for (int i = 0; i < ticTacToeBoard.ticTacToeCells.length; i++) {
            for (int j = 0; j < ticTacToeBoard.ticTacToeCells.length; j++) {
                if (ticTacToeBoard.ticTacToeCells[i][j].content == null) {
                    return new Move(i,j);
                }
            }
        }
        return nextMove();
    }
}


