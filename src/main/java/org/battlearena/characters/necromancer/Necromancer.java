package org.battlearena.characters.necromancer;

import org.battlearena.actions.specialskill.SpecialSkillEnum;
import org.battlearena.characters.Character;


import java.util.EnumSet;

public class Necromancer extends Character {

    public Necromancer() {
        super("Necromancer",
                NecromancerStats.MAX_HP.getValue(),
                NecromancerStats.MIN_HP.getValue(),
                NecromancerStats.MIN_ATTACK_DAMAGE.getValue(),
                NecromancerStats.MAX_ATTACK_DAMAGE.getValue(),
                NecromancerStats.MIN_DEFEND.getValue(),
                NecromancerStats.MAX_DEFEND.getValue(),
                EnumSet.of(SpecialSkillEnum.DRAIN, SpecialSkillEnum.CURSE));
    }
}
