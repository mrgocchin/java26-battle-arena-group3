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
                break;
            }
        }
        return arePlayersAlive;
    }

    public String assignWinner(ArrayList<Player> players) {
        StringBuilder endGameMessage = new StringBuilder();
        for (Player player : players) {
            if (player.getHp() <= 0) {
                player.setPlayerStatus(PlayerStatus.LOSER);
                endGameMessage.append(player.gameOverMessage());
            }
        }
        for (Player player : players) {
            if (player.getPlayerStatus() != PlayerStatus.LOSER) {
                player.setPlayerStatus(PlayerStatus.WINNER);
                endGameMessage.append(player.winnerMessage());
            }
        }
        endGameMessage.append("\n");
            if (players.getFirst().getPlayerStatus() == PlayerStatus.LOSER && players.getLast().getPlayerStatus() == PlayerStatus.LOSER){
                String totalGameOverMessage = "Both players died in the last turn. There is no winner this time.";
                endGameMessage.append(totalGameOverMessage);
            }
        return endGameMessage.toString();
    }

}
