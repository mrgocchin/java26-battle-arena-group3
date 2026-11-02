package org.battlearena.turns;

import org.battlearena.player.Player;

public class Turn {
    private int turnCount = 0;
    private int actionCount = 0;
    private boolean hasAttackedThisTurn = false;
    private Player currentPlayer;
}
