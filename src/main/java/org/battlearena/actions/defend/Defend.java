package org.battlearena.actions.defend;

import org.battlearena.actions.Actionable;
import org.battlearena.player.Player;

public class Defend implements Actionable {
    private Player player;

    public Defend(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    private Player opponent;

    @Override
    public void perform() {
        player.setDefending();
    }
}
