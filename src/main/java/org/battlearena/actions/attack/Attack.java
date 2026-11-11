package org.battlearena.actions.attack;

import org.battlearena.actions.Actionable;
import org.battlearena.characters.Character;
import org.battlearena.player.Player;

import java.util.Random;

public class Attack implements Actionable {
    private final Random random = new Random();

    @Override
    public void perform() {
        // TODO
    }

    public int calculateDamage(Player attacker) {
        Character playerCharacter = attacker.getPlayerCharacter();

        int maxAttack = playerCharacter.getMaxAttackDamage();
        int minAttack = playerCharacter.getMinAttackDamage();

        int damage = random.nextInt(minAttack, maxAttack + 1);

        return damage;

    }
}
