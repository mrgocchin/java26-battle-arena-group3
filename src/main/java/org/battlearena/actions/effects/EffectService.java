package org.battlearena.actions.effects;

import org.battlearena.player.Player;

public class EffectService {

    protected void addEffect(Player target, SpecialEffect effect) {
        target.getEffects().put(effect.name(), effect);
    }

    public boolean hasEffect(Player player, SpecialEffect effect) {
        return player.getEffects().containsKey(effect.name());
    }

    public boolean playerIsCursed(Player player) {
        return hasEffect(player, SpecialEffect.CURSED);
    }

    public boolean playerHasExtraAttackPower(Player player) {
        return hasEffect(player, SpecialEffect.EXTRA_ATTACK_POWER);
    }

    public boolean playerIsKnockedDown(Player player) {
        return hasEffect(player, SpecialEffect.KNOCKDOWN);
    }

    public boolean opponentHasStability(Player opponent) {
        return hasEffect(opponent, SpecialEffect.STABILITY);
    }

    public boolean opponentIsWarded(Player opponent) {
        return hasEffect(opponent, SpecialEffect.WARD);
    }
}
