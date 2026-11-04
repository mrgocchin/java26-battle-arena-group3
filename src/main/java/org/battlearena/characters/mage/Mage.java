package org.battlearena.characters.mage;

import org.battlearena.actions.specialskill.SpecialSkillEnum;
import org.battlearena.characters.Character;

import java.util.ArrayList;
import java.util.EnumSet;

public class Mage extends Character {
    protected String name = "Mage";
    protected int maxHp = MageStats.MAX_HP.getValue();
    protected int minHP = MageStats.MIN_HP.getValue();
    protected int minAttackDamage = MageStats.MIN_ATTACK_DAMAGE.getValue();
    protected int maxAttackDamage = MageStats.MAX_ATTACK_DAMAGE.getValue();
    protected EnumSet<SpecialSkillEnum> mageSpecialSkills = EnumSet.of(SpecialSkillEnum.FIREBALL,SpecialSkillEnum.HEALING);

    public Mage() {
    }

    @Override
    public int getMinAttackDamage() {
        return minAttackDamage;
    }

    @Override
    public int getMaxAttackDamage() {
        return maxAttackDamage;
    }

    @Override
    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public int getMinHP() {
        return minHP;
    }



}
