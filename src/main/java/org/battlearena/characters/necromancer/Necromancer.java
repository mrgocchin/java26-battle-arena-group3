package org.battlearena.characters.necromancer;

import org.battlearena.actions.specialskill.SpecialSkillEnum;
import org.battlearena.characters.Character;

import java.util.EnumSet;

public class Necromancer extends Character {
    private static final String NAME = "Necromancer";
    private static final int MAX_HP = 100;
    private static final int MIN_HP = 0;
    private static final int MIN_ATTACK_DAMAGE = 3;
    private static final int MAX_ATTACK_DAMAGE = 12;

    public Necromancer() {
        super(NAME,
                MAX_HP,
                MIN_HP,
                MIN_ATTACK_DAMAGE,
                MAX_ATTACK_DAMAGE,
                EnumSet.of(SpecialSkillEnum.DRAIN, SpecialSkillEnum.CURSE));
    }
}
