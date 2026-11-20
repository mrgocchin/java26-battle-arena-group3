package org.battlearena.turns;

import org.battlearena.actions.Actionable;
import org.battlearena.actions.attack.Attack;
import org.battlearena.characters.necromancer.Necromancer;
import org.battlearena.characters.warrior.Warrior;
import org.battlearena.exceptions.ExceededActionException;
import org.battlearena.exceptions.InvalidInputException;
import org.battlearena.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnTest {
    private Turn turn;

    @BeforeEach
    void setUp() {
        this.turn = new Turn();
        turn.setFirstPlayer(new Player("Picard", new Warrior()));
        turn.setSecondPlayer(new Player("Skywalker", new Necromancer()));
    }

    @Test
    void decreasingRoundsRemainingShouldDecreaseIfNotZero() {
        assertEquals(2, turn.getRoundsRemaining());

        turn.decreaseRounds();
        turn.decreaseRounds();
        turn.decreaseRounds();

        assertEquals(0, turn.getRoundsRemaining());
    }

    @Test
    void selectActionShouldReturnActionAtValidInput() {
        Player player = turn.getFirstPlayer();
        Player opponent = turn.getSecondPlayer();
        Actionable expected = new Attack(player, opponent);

        assertDoesNotThrow(() -> {
            Actionable actual = turn.selectAction("attack", player, opponent);
            assertNotNull(actual);
            assertEquals(expected.getClass(), actual.getClass());
        });
    }

    @Test
    void selectActionShouldThrowExceptionAtInValidInput() {
        Player player = turn.getFirstPlayer();
        Player opponent = turn.getSecondPlayer();
        assertThrows(InvalidInputException.class, () -> {
            turn.selectAction("loiter", player, opponent);
        });
    }

    @Test
    void turnActionsThrowsExceptionIfPlayerAlreadyUsedUpTheirActions() {
        Player player = turn.getFirstPlayer();

        assertDoesNotThrow(() -> {
            player.increaseActionCount();
            player.increaseActionCount();
        });

        assertThrows(ExceededActionException.class, () -> {
           turn.turnActions(player, turn.getSecondPlayer());
        });
    }
}