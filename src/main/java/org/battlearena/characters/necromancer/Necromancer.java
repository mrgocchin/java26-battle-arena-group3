package org.battlearena.characters.necromancer;

import org.battlearena.characters.Character;

public class Necromancer extends Character {

    protected final int hp = 7777;

    public Necromancer() {

    }

    @Override
    public int getMinAttackDamage() {
        return 0;
    }

    @Override
    public int getMaxAttackDamage() {
        return 0;
    }

    @Override
    public int getMaxHp() {
        return 0;
    }

    @Override
    public int getMinHP() {
        return 0;
    }
}
