package org.battlearena.actions.attack;

import org.battlearena.characters.mage.Mage;
import org.battlearena.characters.necromancer.Necromancer;
import org.battlearena.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttackTest {
    Player attackerTest = new Player("testAttacker", new Mage());
    Player opponentTest = new Player("testOpponent", new Necromancer());
    Attack attackActionTest = new Attack(attackerTest, opponentTest);


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
}