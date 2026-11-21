package org.battlearena.characters;


import org.battlearena.actions.specialskill.SpecialSkillEnum;

import java.util.Random;
import java.util.EnumSet;

public abstract class Character {
    protected String name;
    protected int maxHp;
    protected int minHp;
    protected int minAttackDamage;
    protected int maxAttackDamage;
    protected EnumSet<SpecialSkillEnum> specialSkills;
    protected Random random;


    protected Character(String name, int maxHp, int minHp,
                        int minAttackDamage, int maxAttackDamage,
                        EnumSet<SpecialSkillEnum> specialSkills) {
        this.name = name;
        this.maxHp = maxHp;
        this.minHp = minHp;
        this.minAttackDamage = minAttackDamage;
        this.maxAttackDamage = maxAttackDamage;
        this.specialSkills = specialSkills;
        this.random = new Random();
    }

    public String getName() {
        return name;
    }

    public int getMinAttackDamage() {
        return minAttackDamage;
    }

    public int getMaxAttackDamage() {
        return maxAttackDamage;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMinHp() {
        return minHp;
    }

}

//      special skills needs some extra thinking depending on how we'll use it.
//      public EnumSet<SpecialSkillEnum> getSpecialSkills() { return specialSkills;}




