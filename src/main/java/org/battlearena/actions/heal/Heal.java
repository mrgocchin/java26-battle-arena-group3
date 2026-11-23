package org.battlearena.actions.heal;

import org.battlearena.actions.Actionable;
import org.battlearena.player.Player;

public class Heal implements Actionable {
    private Player healingPlayer;
    private int healAmount;

    @Override
    public void perform() {
        calculateHealAmount();
        applyHealing();
        IO.println(getActionSummary());
    }

    //to be removed
    @Override
    public String getDescription() {
        return "nothing to return. remove this method in next refactoring ";
    }

    public Heal(Player healingPlayer) {
        this.healingPlayer = healingPlayer;
    }

    public int calculateHealAmount() {
        int healAmount = healingPlayer.getPlayerCharacter().getMaxHp() / 10;
        return healAmount;
    }

    public void applyHealing() {
        int currentHp = healingPlayer.getHp();
        int healAmount = calculateHealAmount();
        int newHp = currentHp + healAmount;
        if (newHp > healingPlayer.getPlayerCharacter().getMaxHp()) {
            newHp = healingPlayer.getPlayerCharacter().getMaxHp();
        }
        healingPlayer.setHp(newHp);
    }

    @Override
    public String getActionSummary() {
        String summaryOfHealing = "The " + healingPlayer.getPlayerCharacter().getName() +
                " played by " + healingPlayer.getName() +
                " has healed for: " + healAmount +
                "HP, and now stand with: " + healingPlayer.getHp() + "Hp";
        return summaryOfHealing;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }
}
