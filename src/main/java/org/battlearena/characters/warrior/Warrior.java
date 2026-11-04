package org.battlearena.characters.warrior;

import org.battlearena.characters.Character;

public class Warrior extends Character {
    protected final int hp = 6666;


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
