package com.app.game.tictactoerunner.player;

import java.util.List;

public class Players {
    private List<Player> playerList;
    private int currentPlayerIndex;

    public Players(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Player nextPlayer() {
        Player player = playerList.get(currentPlayerIndex);
        currentPlayerIndex++;
        if (currentPlayerIndex == playerList.size()) {
            currentPlayerIndex = 0;
        }
        return player;
    }

}
