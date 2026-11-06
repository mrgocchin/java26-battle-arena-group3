package org.battlearena.characters.warrior;

import org.battlearena.actions.specialskill.SpecialSkillEnum;
import org.battlearena.characters.Character;
import org.battlearena.characters.mage.MageStats;

import java.util.EnumSet;

public class Warrior extends Character {
    public Warrior() { super("Warrior",
            WarriorStats.MAX_HP.getValue(),
            WarriorStats.MIN_HP.getValue(),
            WarriorStats.MIN_ATTACK_DAMAGE.getValue(),
            WarriorStats.MAX_ATTACK_DAMAGE.getValue(),
            WarriorStats.MIN_DEFEND.getValue(),
            WarriorStats.MAX_DEFEND.getValue(),
            EnumSet.of(SpecialSkillEnum.ADRENALINE, SpecialSkillEnum.SHIELD_BASH));
    
    }
// to be moved to different classes
    public void takeDamage(){
        setHp(getHp()-getDamage());
    }

    public void Defend(){
        setHp(getHp()+ getDefend());
    }
    public void AdrenalineRush(){
        int bonus = SpecialSkillEnum.ADRENALINE.getValue();
        setMinAttackDamage(getDamage() + bonus);
    }
    
    }
