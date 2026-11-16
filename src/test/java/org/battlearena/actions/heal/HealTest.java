package org.battlearena.actions.heal;

import org.battlearena.characters.warrior.Warrior;
import org.battlearena.player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealTest {
    private Player healingPlayer;
    private int healAmount;
    private Heal healActionTest;

    @BeforeEach
    void setUp() {
        healingPlayer = new Player("testHealer", new Warrior());
        healActionTest = new Heal(healingPlayer);

    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void calculateHealShouldBe10PerCentOfMaxHp() {
        int expectedHealingWarrior = 10;
        int actualHealing = healActionTest.calculateHealAmount();
        System.out.println(expectedHealingWarrior);
        System.out.println(actualHealing);
        assertEquals(expectedHealingWarrior, actualHealing);
    }

    @Test
    void applyhealing() {
        healingPlayer.setHp(50);
        healActionTest.applyhealing();
    }

    @Test
    void healSummary() {
    }
}