package org.battlearena.actions.effects;

import org.battlearena.characters.mage.Mage;
import org.battlearena.characters.warrior.Warrior;
import org.battlearena.player.Player;
import org.battlearena.turns.Turn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EffectServiceTest {

    EffectService service;
    private Player player;
    private Player opponent;
    private Turn turn;

    @BeforeEach
    void setUp() {
        service = new EffectService();
        player = new Player("Picard", new Mage());
        opponent = new Player("Skywalker", new Warrior());
        turn = new Turn();
    }

    @Test
    public void attackPowerIsInEffect() {
        service.addEffect(player, SpecialEffect.EXTRA_ATTACK_POWER);

        boolean actual = service.hasEffect(player, SpecialEffect.EXTRA_ATTACK_POWER);
        assertTrue(actual);
    }

    @Test
    void applyEffectAddsEffectWhenNotCountered() {
        // Check for counters for CURSED
        // Remember, this is testing logic in the generic applyEffect,
        //    so we don't want to use the direct approach (e.g. opponentIsWarded() etc)

        // Firstly, we verify directly that the opponent doesn't have any effects
        SpecialEffect counterEffect = SpecialEffect.CURSED.getCounterEffect();
        assertTrue(opponent.getEffects().isEmpty());

        // a) No counters at all
        service.applyEffect(opponent, SpecialEffect.CURSED);
        // b) STABILITY effect is on opponent - but _not_ WARD
        service.addEffect(opponent, SpecialEffect.STABILITY);

        // Now verify effects are added
        assertFalse(opponent.getEffects().isEmpty());
        // Add effect to opponent

        // Verify opponent is Cursed
        assertTrue(service.playerIsCursed(opponent));
    }

    @Test
    void applyEffectDoesNotAddEffectWhenCountered() {
        // Check for counters for KNOCKDOWN
        // Counter STABILITY is in place
        // KNOCKDOWN is not added to opponent
    }
}