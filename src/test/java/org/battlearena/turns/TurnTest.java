package org.battlearena.turns;

import org.battlearena.characters.mage.Mage;
import org.battlearena.exceptions.ExceededActionException;
import org.battlearena.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnTest {
    private Turn turn;
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Jane Doe", new Mage());
        turn = new Turn(player);
    }

    @Test
    void increaseActionCountIncreasesTheCount() {
        int actualBeforeIncrease = turn.getActionCount();
        assertEquals(0, actualBeforeIncrease);

        assertDoesNotThrow(() -> {
            turn.increaseActionCount();
        });
        int actualAfterIncrease = turn.getActionCount();
        assertEquals(1, actualAfterIncrease);

        assertDoesNotThrow(() -> {
            turn.increaseActionCount();
        });
        int actualAfterAnotherIncrease = turn.getActionCount();
        assertEquals(2, actualAfterAnotherIncrease);
    }

    @Test
    void increaseActionCountThrowsExceptionIfMoreThanTwoActions() {
        int actualBeforeIncrease = turn.getActionCount();
        assertEquals(0, actualBeforeIncrease);

        assertThrows(ExceededActionException.class, () -> {
            turn.increaseActionCount();
            turn.increaseActionCount();
            turn.increaseActionCount();
        });
        int actualAfterIncrease = turn.getActionCount();
        assertEquals(2  , actualAfterIncrease);
    }
}