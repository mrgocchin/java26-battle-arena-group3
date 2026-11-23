package org.battlearena.turns;

import org.battlearena.player.Player;
import org.battlearena.player.PlayerStatus;

import java.util.ArrayList;

public class Results {

     public boolean alivePlayersCheck(ArrayList<Player> players) {
        boolean arePlayersAlive = true;
        for (Player player : players) {
            if (player.getHp() <= 0) {
                arePlayersAlive = false;
                //unsure about break here.
                //can both player die in the same turn?
                break;
            }
        }
        return arePlayersAlive;
    }
    //this method should only assign winner but for now it also returns messages.
    // can be refactored to 2 different methods.
    public String assignWinner(ArrayList<Player> players) {
        StringBuilder endGameMessage = new StringBuilder();
        for (Player player : players) {
            if (player.getHp() <= 0) {
                player.setPlayerStatus(PlayerStatus.LOSER);
                endGameMessage.append(player.gameOverMessage());
            }
        }
        endGameMessage.append("\n");
        for (Player player : players) {
            if (player.getPlayerStatus() != PlayerStatus.LOSER) {
                player.setPlayerStatus(PlayerStatus.WINNER);
                endGameMessage.append(player.winnerMessage());
            }
        }
        return endGameMessage.toString();
    }

}
