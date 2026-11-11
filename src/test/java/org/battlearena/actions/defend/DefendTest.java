package org.battlearena.actions.defend;

import org.battlearena.actions.Actionable;
import org.battlearena.characters.mage.Mage;
import org.battlearena.characters.warrior.Warrior;
import org.battlearena.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefendTest {
    private Player player;
    private Player opponent;

    @BeforeEach
    void setUp() {
        player = new Player("Picard", new Warrior());
        opponent = new Player("Skywalker", new Mage());
    }

    @Test
    void perform() {
        Actionable action = new Defend(player, opponent);
        assertFalse(player.isDefending());

        action.perform();

        assertTrue(player.isDefending());
    }
}