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
    void calculateHealShouldBe1TenthOfMaxHp() {
        int expectedHealingWarrior = healingPlayer.getPlayerCharacter().getMaxHp() / 10;
        int actualHealing = healActionTest.calculateHealAmount();
        //System.out.println(expectedHealingWarrior);
        //System.out.println(actualHealing);
        assertEquals(expectedHealingWarrior, actualHealing);
    }

    @Test
    void applyHealingShouldNotGoAboveMaxHp() {
        int maxHealthWarrior = healingPlayer.getPlayerCharacter().getMaxHp();
        healingPlayer.setHp(95);
        healActionTest.applyHealing();
        System.out.println(healingPlayer.getHp());
        assertEquals(maxHealthWarrior,maxHealthWarrior);

    }

    @Test
    void healSummaryShouldReturnRightString() {
        int healTest = 10;
        healingPlayer.setHp(50);
        healActionTest.setHealAmount(healTest);
        String summaryOfTheHealingAction = healActionTest.getActionSummary();
        String expectedSummary = "The Warrior played by testHealer has healed for: 10HP, and now stand with: 50Hp";
        System.out.println(summaryOfTheHealingAction);
        System.out.println(expectedSummary);
        assertEquals(expectedSummary,summaryOfTheHealingAction);
    }
}