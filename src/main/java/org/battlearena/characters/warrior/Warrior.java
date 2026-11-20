package org.battlearena.characters.warrior;

import org.battlearena.actions.specialskill.SpecialSkillEnum;
import org.battlearena.characters.Character;

import java.util.EnumSet;

public class Warrior extends Character {
    private static final String NAME = "Warrior";
    private static final int MAX_HP = 100;
    private static final int MIN_HP = 0;
    private static final int MIN_ATTACK_DAMAGE = 3;
    private static final int MAX_ATTACK_DAMAGE = 12;

    public Warrior() {
        super(
                NAME,
                MAX_HP,
                MIN_HP,
                MIN_ATTACK_DAMAGE,
                MAX_ATTACK_DAMAGE,
                EnumSet.of(SpecialSkillEnum.ADRENALINE, SpecialSkillEnum.SHIELD_BASH));

    }

}
