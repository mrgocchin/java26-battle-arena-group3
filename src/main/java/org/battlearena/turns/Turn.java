package org.battlearena.turns;

import org.battlearena.exceptions.ExceededActionException;
import org.battlearena.player.Player;

public class Turn {
    private static int turnCount = 0;
    private int actionCount = 0;
    private boolean hasAttackedThisTurn = false;
    private Player currentPlayer;

    public Turn(Player player) {
        this.currentPlayer = player;

        turnCount++;
    }

    public void increaseActionCount() throws ExceededActionException {
        if (actionCount >= 2) {
            throw new ExceededActionException("You have already used your two actions, and cannot do anything else until your next turn.");
        }
        actionCount++;
    }

    public boolean hasAttackedThisTurn() {
        return hasAttackedThisTurn;
    }

    public int getActionCount() {
        return actionCount;
    }

    public void setHasAttackedThisTurn(boolean hasAttackedThisTurn) {
        this.hasAttackedThisTurn = hasAttackedThisTurn;
    }
}
