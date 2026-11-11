package org.battlearena.characters;


import org.battlearena.actions.specialskill.SpecialSkillEnum;
import org.battlearena.characters.warrior.WarriorStats;
import java.util.Random;

import java.util.EnumSet;

public abstract class Character {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int minHp;
    protected int minAttackDamage;
    protected int maxAttackDamage;
    protected int minDefend;
    protected int maxDefend;
    protected EnumSet<SpecialSkillEnum> specialSkills;
    protected Random random;

    protected Character(String name, int maxHp, int minHp,
                        int minAttackDamage, int maxAttackDamage, int minDefend, int maxDefend,
                        EnumSet<SpecialSkillEnum> specialSkills) {
        this.name = name;
        this.maxHp = maxHp;
        this.minHp = minHp;
        this.hp = maxHp;
        this.minAttackDamage = minAttackDamage;
        this.maxAttackDamage = maxAttackDamage;
        this.minDefend = minDefend;
        this.maxDefend = maxDefend;
        this.specialSkills = specialSkills;
        this.random = new Random();
}
        public String getName () {
            return name;
        }

        public int getMinAttackDamage () {
            return minAttackDamage;
        }

        public int getMaxAttackDamage () {
            return maxAttackDamage;
        }

        public void setMinAttackDamage ( int minAttackDamage){
            this.minAttackDamage = minAttackDamage;
        }
        public void setMaxAttackDamage ( int maxAttackDamage){
            this.maxAttackDamage = maxAttackDamage;
        }
        public int getMinDefend () {
            return minDefend;
        }

        public int getMaxDefend () {
            return maxDefend;
        }

        public int getMaxHp () {
            return maxHp;
        }

        public int getMinHp () {
            return minHp;
        }
//  getHP, setHp  maybe to be moved to player class
// so player class is responsible to handle current game stats.

        public int getHp () {
            return hp;
        }

        public void setHp ( int hp){
            if (hp > WarriorStats.MAX_HP.getValue()) {
                this.hp = WarriorStats.MAX_HP.getValue();
            } else if (hp < WarriorStats.MIN_HP.getValue()) {
                this.hp = WarriorStats.MIN_HP.getValue();
            } else {
                this.hp = hp;
            }
        }
        // getDamage, getDefend, to be moved to attack and defend classes.
        public int getDamage () {
            int damage = random.nextInt(getMinAttackDamage(), getMaxAttackDamage() + 1);
            return damage;
        }

        public int getDefend () {
            int defend = random.nextInt(getMinDefend(), getMaxDefend() + 1);
            return defend;
        }
//IsAlive to be moved to player class
        public boolean isAlive () {
            return hp > 0;
        }


        //get special skills needs some extra thinking depending on how we'll use it.
        // public EnumSet<SpecialSkillEnum> getSpecialSkills() { return specialSkills;}


    }

   