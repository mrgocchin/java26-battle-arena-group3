package org.battlearena.actions.attack;

import org.battlearena.actions.Actionable;
import org.battlearena.characters.Character;
import org.battlearena.player.Player;

import java.util.Random;

public class Attack implements Actionable {
    private Player attacker;
    private Player opponent;

    public Attack(Player attacker, Player opponent) {
        this.attacker = attacker;
        this.opponent = opponent;
    }

    private final Random random = new Random();
    private int damage;

    @Override
    public void perform() {
        calculateDamage();
        applyDamage();
        opponent.setNotDefending();
        attacker.setHasAttackedThisTurn(true);
    }

    public int calculateDamage() {
        Character playerCharacter = attacker.getPlayerCharacter();

        int maxAttack = playerCharacter.getMaxAttackDamage();
        int minAttack = playerCharacter.getMinAttackDamage();

        damage = (random.nextInt(minAttack, maxAttack + 1));

        return damage;
    }

    public void applyDamage() {
        int currentHp = opponent.getHp();
        if (opponent.isDefending()) {
            damage = 0;
        }
        int newHp = currentHp - damage;
        if (newHp < opponent.getPlayerCharacter().getMinHp()) {
            newHp = opponent.getPlayerCharacter().getMinHp();
        }
        opponent.setHp(newHp);
    }

    @Override
    public String getActionSummary() {
        String attackSummary = "The " + attacker.getPlayerCharacter().getName() +
                " played by " + attacker.getName() +
                " inflicted a damage of: " + damage +
                "Hp against the " + opponent.getPlayerCharacter().getClass().getSimpleName() +
                " played by " + opponent.getName() +
                ", which now stand with: " + opponent.getHp() + "Hp";
        return attackSummary;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

