package org.battlearena.characters;

import org.battlearena.actions.specialskill.SpecialSkillEnum;

import java.util.EnumSet;

public abstract class Character {
    protected String name;
    protected int maxHp;
    protected int minHP;
    protected int minAttackDamage;
    protected int maxAttackDamage;
    protected EnumSet<SpecialSkillEnum> specialSkills;


    public abstract int getMinAttackDamage();

    public abstract int getMaxAttackDamage();

    public abstract int getMaxHp();

    public abstract int getMinHP();

    // public abstract int getSpecialSkills();
}
// commenting out getHP maybe to be moved to player class
// so player class is responsible to handle current game stats.
    /*
    public int getHP() {
        return this.hp;
    }

     */