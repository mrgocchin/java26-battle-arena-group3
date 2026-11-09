package org.battlearena.actions.effects;

public enum SpecialEffect {
    /** Defensive Effects */
    BLOCKING(null),
    STABILITY(null),
    WARD(null), // NOTE: This is pending decision from the team

    /** Offensive Effects */
    KNOCKDOWN(STABILITY), // from shield
    CURSED(WARD), // from curse
    EXTRA_ATTACK_POWER(null); // from adrenaline


    private SpecialEffect counterEffect;

    SpecialEffect(SpecialEffect counterEffect) {
        this.counterEffect = counterEffect;
    }

    public SpecialEffect getCounterEffect() {
        return this.counterEffect;
    }
}
