package org.battlearena.actions.effects;

public class Effect {
    /* TODO
        - Add effects:
            - Offensive effects
                - Knockdown (from Shield Bash (warrior), Gust (mage))
                - Cursed (from Curse)
            - Defensive effects
                - Blocking (from Defense) (counters regular attacks)
                - Stability (from Stability) (counters Knockdown)

            Potential effects (need to discuss with group)
            - Maybe some effect from Adrenaline rush?

           Special skills that are NOT required to be effects:
            - Drain (just decrease health from opponent immediately and increase attacker's HP right away)
     */

    /* So how should effects work?
        Turn 1, Action 1: Player 1 has selected ATTACK.
            Player 1 attacks.
            We check for effects (player.getEffects())
            There are no effects.
            We calculate damage. (we calculate damage after, because we'd take effects into account)
            We check for countering effects on opponent. (opponent.getEffects())
            There are no such effects.
            Opponent's HP is decreased by the damage.
            (the action has ended, and any other checks such as HP status etc is outside the action scope)

        Turn 1, Action 2: Player 1 has selected SHIELD_BASH.
            Player 1 attacks.
            We check for effects (player.getEffects())
            There are no effects.
            Calculation: We could do success rate; simulate 1D20 roll. Or just do automatic success.
            We check for countering effects on opponent. (opponent.getEffect().getCounteringEffect())
            There are no such effects. (ie nothing to counter)



         TODO - in Player:
            - getEffects()


        TODO - in Effect (or within its package)
            - getCounteringEffect()
         */
    private SpecialEffect effect;

    public Effect(SpecialEffect effect) {
        this.effect = effect;
    }

    public SpecialEffect getEffect() {
        return effect;
    }

    public boolean hasExtraAttackPower() {
        return effect == SpecialEffect.EXTRA_ATTACK_POWER;
    }

    public boolean isCountered() {
        return true; // NOTE - PLACEHOLDER
    }

}
