package org.battlearena.actions.specialskill;

import org.battlearena.actions.Actionable;

public class SpecialSkill implements Actionable {
    @Override
    public void perform() {
        // TODO

    }

    @Override
    public String getActionSummary() {
        String summaryOfSpecialSkill = "Special skills not available yet! stay tuned!";
//                + healingPlayer.getPlayerCharacter().getName() +
//                " played by " + healingPlayer.getName() +
//                " has healed for: " + healAmount +
//                "HP, and now stand with: " + healingPlayer.getHp() + "Hp"

        return summaryOfSpecialSkill;
    }
}
