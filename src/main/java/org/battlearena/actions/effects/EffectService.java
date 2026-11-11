package org.battlearena.actions.effects;

import org.battlearena.player.Player;

// Note: For refactoring - can we come up with something more suitable than "Service"?
public class EffectService {
    // TODO: Add method to detect the player has increased attack power

    // TODO: Add method to detect opponent is blocking

    // TODO (maybe?)
    public void addEffect(Player player, Effect effect) {
        player.getEffects().put(effect.getEffect().name(), effect);
    }

    public boolean hasEffect(Player player, SpecialEffect effect) {
        return player.getEffects().containsKey(effect.name());
    }
}
