package org.battlearena.turns;

import org.battlearena.player.Player;
import org.battlearena.player.PlayerStatus;
import org.battlearena.player.CharacterCreator;

import java.util.ArrayList;
import java.util.Scanner;

public class Results {
    private CharacterCreator characterCreator; 
    private ArrayList<Player> players;

    public Results(CharacterCreator cc) {
        this.players = new ArrayList<>();
        this.characterCreator = cc;
    }

     public boolean alivePlayersCheck() {
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
    public boolean isGameOver(){
        return !alivePlayersCheck();
    }
 
    //this method should only assign winner but for now it also returns messages.
    // can be refactored to 2 different methods.
    public String assignWinner() {
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
