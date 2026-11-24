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

    @Override
    public String getActionSummary() {
        String defendSummary = "The " + player.getPlayerCharacter().getName() +
                " played by " + player.getName() +
                " is defending themself from the next attack coming from" + opponent.getPlayerCharacter().getName() +
                " played by " + opponent.getName();
        return defendSummary;
    }


}
