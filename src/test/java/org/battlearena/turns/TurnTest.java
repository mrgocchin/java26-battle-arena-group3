package org.battlearena.turns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnTest {
    private Turn turn;

    @BeforeEach
    void setUp() {
        this.turn = new Turn();
    }

    @Test
    void decreasingRoundsRemainingShouldDecreaseIfNotZero() {
        assertEquals(2, turn.getRoundsRemaining());

        turn.decreaseRounds();
        turn.decreaseRounds();
        turn.decreaseRounds();

        assertEquals(0, turn.getRoundsRemaining());
    }
}