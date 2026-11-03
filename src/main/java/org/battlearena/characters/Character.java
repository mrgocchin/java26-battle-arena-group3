package org.battlearena.characters;

public abstract class Character {
    protected int hp;
    protected int minAttackDamage;
    protected int maxAttackDamage;

    public int getHP() {
        return this.hp;
    }
}
