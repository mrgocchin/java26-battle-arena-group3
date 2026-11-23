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

    //to be removed
    @Override
    public String getDescription() {
        return "nothing to return. remove this method in next refactoring";
    }

    @Override
    public void perform() {
        player.setDefending();
        IO.println(getActionSummary());
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
