package org.battlearena.actions.effects;

import org.battlearena.actions.specialskill.SpecialSkill;
import org.battlearena.characters.mage.Mage;
import org.battlearena.characters.warrior.Warrior;
import org.battlearena.player.Player;
import org.battlearena.turns.Turn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

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
        turn = new Turn(player);
    }

    @Test
    public void attackPowerIsInEffect() {
        Effect effect = new Effect(SpecialEffect.EXTRA_ATTACK_POWER);
        service.addEffect(player, effect);

        boolean actual = service.hasEffect(player, SpecialEffect.EXTRA_ATTACK_POWER);
        assertTrue(actual);
    }
}