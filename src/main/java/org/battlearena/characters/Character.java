package org.battlearena.characters;

import org.battlearena.actions.specialskill.SpecialSkill;
import org.battlearena.actions.specialskill.SpecialSkillEnum;

import java.util.EnumSet;

public abstract class Character {
    protected String name;
    protected int maxHp;
    protected int minHP;
    protected int minAttackDamage;
    protected int maxAttackDamage;
    protected EnumSet<SpecialSkillEnum> specialSkills;

    protected Character(String name, int maxHp, int minHP,
                        int minAttackDamage, int maxAttackDamage,
                        EnumSet<SpecialSkillEnum> specialSkills) {
        this.name = name;
        this.maxHp = maxHp;
        this.minHP = minHP;
        this.minAttackDamage = minAttackDamage;
        this.maxAttackDamage = maxAttackDamage;
        this.specialSkills = specialSkills;
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

    public int getMinHP() {
        return minHP;
    }
    //get special skills needs some extra thinking depending on how we'll use it.
   // public EnumSet<SpecialSkillEnum> getSpecialSkills() { return specialSkills;}



}
// commenting out getHP maybe to be moved to player class
// so player class is responsible to handle current game stats.
    /*
    public int getHP() {
        return this.hp;
    }

     */