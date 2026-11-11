package org.battlearena.characters.mage;

import org.battlearena.actions.specialskill.SpecialSkillEnum;
import org.battlearena.characters.Character;


import java.util.EnumSet;

public class Mage extends Character {
    public Mage() { super("Mage",
            MageStats.MAX_HP.getValue(),
            MageStats.MIN_HP.getValue(),
            MageStats.MIN_ATTACK_DAMAGE.getValue(),
            MageStats.MAX_ATTACK_DAMAGE.getValue(),
            MageStats.MIN_DEFEND.getValue(),
            MageStats.MAX_DEFEND.getValue(),
            EnumSet.of(SpecialSkillEnum.WARD, SpecialSkillEnum.STABILITY));
    }
}
// refactoring later to better use enum