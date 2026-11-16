package org.battlearena.turns;

import org.battlearena.player.Player;

public class Turn {
    private static int turnCount = 0;
    private int roundsRemaining = 2;
    private Player firstPlayer;
    private Player secondPlayer;

    public Turn() {
        turnCount++;
    }

    public void decreaseRounds() {
        if (roundsRemaining == 0) {
            return;
        }
        roundsRemaining--;
    }

    public void setFirstPlayer(Player player) {
        firstPlayer = player;
    }

    public void setSecondPlayer(Player player) {
        secondPlayer = player;
    }

    public int getRoundsRemaining() {
        return roundsRemaining;
    }
}
