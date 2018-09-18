package com.app.game.tictactoerunner.player;


import java.util.Scanner;

public class HumanPlayer extends Player {
    private static Scanner in = new Scanner(System.in);

    public HumanPlayer(String symbol, String name) {
        super(symbol, name);
    }

    @Override
    public Move nextMove() {
        System.out.println(this.getName()+", Enter the Move in row,col format where row,col start from 1 up to size of the game:");
        String input = in.nextLine();
        if(!input.isEmpty() && input.contains(",")){
            String[] split = input.split(",");
            int row = Integer.parseInt(split[0]) - 1;
            int col = Integer.parseInt(split[1]) - 1;
            return new Move(row, col);
        } else {
            return nextMove();
        }

    }
}
