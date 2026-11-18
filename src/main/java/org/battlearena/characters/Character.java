package org.battlearena.characters;


import org.battlearena.actions.specialskill.SpecialSkillEnum;
import org.battlearena.characters.warrior.WarriorStats;

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
    //If we confirm that defend is damage = 0 then defend should be removed from character class.
    // protected int minDefend;
    //protected int maxDefend;

    protected Character(String name, int maxHp, int minHp,
                        int minAttackDamage, int maxAttackDamage,
                        EnumSet<SpecialSkillEnum> specialSkills
                        //If we confirm that defend is damage = 0 then defend should be removed from character class.
                        // int minDefend, int maxDefend
    ) {
        this.name = name;
        this.maxHp = maxHp;
        this.minHp = minHp;
        this.minAttackDamage = minAttackDamage;
        this.maxAttackDamage = maxAttackDamage;
        this.specialSkills = specialSkills;
        this.random = new Random();
        //If we confirm that defend is damage = 0 then defend should be removed from character class.
        //this.minDefend = minDefend;
        //this.maxDefend = maxDefend;
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

    public void setMinAttackDamage(int minAttackDamage) {
        this.minAttackDamage = minAttackDamage;
    }

    public void setMaxAttackDamage(int maxAttackDamage) {
        this.maxAttackDamage = maxAttackDamage;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMinHp() {
        return minHp;
    }

}

//        If we confirm that defend is damage = 0 then defend should be removed from character class.
//        public int getDefend () {
//            int defend = random.nextInt(getMinDefend(), getMaxDefend() + 1);
//            return defend;
//        }

//      get special skills needs some extra thinking depending on how we'll use it.
//      public EnumSet<SpecialSkillEnum> getSpecialSkills() { return specialSkills;}




   