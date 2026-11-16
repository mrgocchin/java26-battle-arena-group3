package org.battlearena.actions.heal;

import org.battlearena.actions.Actionable;
import org.battlearena.player.Player;

public class Heal  implements Actionable{
private Player healingPlayer;
private int healAmount;

    @Override
    public void perform() {

    }
    public Heal (Player healingPlayer){
        this.healingPlayer = healingPlayer;
    }

    public int calculateHealAmount() {
        double healAmountDouble = healingPlayer.getPlayerCharacter().getMaxHp() * 0.1;
        healAmount = (int) Math.round(healAmountDouble);
        return healAmount;
    }
    public void applyhealing (){
        int currentHp = healingPlayer.getHp();
        int healAmount = calculateHealAmount();
        int newHp = currentHp + healAmount;
        if (newHp > healingPlayer.getPlayerCharacter().getMaxHp()) {
            newHp = healingPlayer.getPlayerCharacter().getMaxHp();
        }
        healingPlayer.setHp(newHp);
    }
    public String healSummary(){
        String summaryOfHealing = "The " + healingPlayer.getPlayerCharacter().getClass().getSimpleName() +
                " played by " + healingPlayer.getName() +
                " has healed for: " + healAmount +
                "HP, and now stand with: " + healingPlayer.getHp() + "Hp";
        return summaryOfHealing;
    }

}
