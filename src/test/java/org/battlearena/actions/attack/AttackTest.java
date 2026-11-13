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
        for (int i = 0; i < 100; i++){
            int damage = attackActionTest.calculateDamage();
            //System.out.println(damage);
            assertTrue(damage <= -3 && damage >= -12, "damage was actually" + damage);
        }
    }


    @Test
    void applyDefenceShouldNullifyDamage() {
        opponentTest.setDefending();
        attackActionTest.setDamage(-12);
        int nullifiedDamage = attackActionTest.applyDefence();
        assertEquals( 0 , nullifiedDamage);

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
        int damagetest = -10;
        opponentTest.setHp(90);
        attackActionTest.setDamage(damagetest);
        String summaryOfTheAttackAction = attackActionTest.attackSummary();
        String expectedSummary = "The Mage played by testAttacker inflicted a damage of:" +
                " -10Hp against the Necromancer played by testOpponent," +
                " which now stand with: 90Hp";
        System.out.println("produced: " + summaryOfTheAttackAction);
        System.out.println("expected: " + expectedSummary);
        assertEquals(expectedSummary,summaryOfTheAttackAction );

    }

    @Test
    void getDamage() {
    }

    @Test
    void setDamage() {
    }


}