package org.battlearena.actions.effects;

import org.battlearena.characters.mage.Mage;
import org.battlearena.characters.warrior.Warrior;
import org.battlearena.player.Player;
import org.battlearena.turns.Turn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EffectServiceTest {

    private Player player;
    private Player opponent;
    private Turn turn;

    @BeforeEach
    void setUp() {
        player = new Player("Picard", new Mage());
        opponent = new Player("Skywalker", new Warrior());
        turn = new Turn(player);
    }

    @Test
    public void attackPowerIsIncreasedIsInEffect() {
        // TODO Friday morning - or Monday evening?
        //    I have an idea we need this Service for digging around in the
        //    player.getEffects() results.
        //   ARRANGE: add effect attack power to the player.
        //   ACT: call the method (which is not created yet, remember TDD)
        //   ASSERT: assert boolean or that Attack power effect is returned
    }
}