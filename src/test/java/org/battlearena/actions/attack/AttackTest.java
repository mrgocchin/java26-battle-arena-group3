package org.battlearena.actions.attack;

import org.battlearena.characters.mage.Mage;
import org.battlearena.characters.necromancer.Necromancer;
import org.battlearena.player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AttackTest {
    Player attackerTest;
    Player opponentTest;
    Attack attackActionTest;

    @BeforeEach
    void setUp() {
        attackerTest = new Player("testAttacker", new Mage());
        opponentTest = new Player("testOpponent", new Necromancer());
        attackActionTest = new Attack(attackerTest, opponentTest);

    }

    @AfterEach
    void tearDown() {
    }




    @Test
    void calculateDamageShouldReturnDamageBetween3and12() {
        for (int i = 0; i < 1000; i++){
            int damage = attackActionTest.calculateDamage();
            //System.out.println(attackActionTest.getDamage());
            assertTrue(damage <= -3 && damage >= -12, "damage was actually" + damage);
        }
    }

    @Test
    void applyDamageShouldNotReduceHpIfOpponentIsDefending() {
        attackActionTest.setDamage(-12);
        opponentTest.setHp(50);
        //System.out.println("damage before defending: " + attackActionTest.getDamage());
        opponentTest.setDefending();
        attackActionTest.applyDamage();
        //System.out.println("damage after defending: " + attackActionTest.getDamage());
        assertEquals(50, opponentTest.getHp());
    }

    @Test
    void applyDamageShouldReduceHp() {
        attackActionTest.setDamage(-12);
        opponentTest.setHp(50);
        attackActionTest.applyDamage();
        assertEquals(38,opponentTest.getHp());
    }
    @Test
    void applyDamageShouldNeverGoBelow0() {
        attackActionTest.setDamage(-12);
        opponentTest.setHp(10);
        attackActionTest.applyDamage();
        assertEquals(0,opponentTest.getHp());
    }
    @Test
    void attackSummaryShouldReturnTheRightString() {
        int damageTest = -10;
        opponentTest.setHp(90);
        attackActionTest.setDamage(damageTest);
        String summaryOfTheAttackAction = attackActionTest.attackSummary();
        String expectedSummary = "The Mage played by testAttacker inflicted a damage of:" +
                " -10Hp against the Necromancer played by testOpponent," +
                " which now stand with: 90Hp";
        //System.out.println("produced: " + summaryOfTheAttackAction);
        //System.out.println("expected: " + expectedSummary);
        assertEquals(expectedSummary,summaryOfTheAttackAction );

    }
}