package org.battlearena.actions.effects;

public enum SpecialEffect {
    /** Defensive Effects */
    STABILITY(null),
    WARD(null),

    /** Boosters */
    EXTRA_ATTACK_POWER(null), // from ADRENALINE

    /** Offensive Effects */
    KNOCKDOWN(STABILITY), // from SHIELD_BASH
    CURSED(WARD); // from CURSE

    private final SpecialEffect counterEffect;

    SpecialEffect(SpecialEffect counterEffect) {
        this.counterEffect = counterEffect;
    }

    public SpecialEffect getCounterEffect() {
        return this.counterEffect;
    }
}
