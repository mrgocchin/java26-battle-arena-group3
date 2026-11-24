package org.battlearena.player;

import org.battlearena.characters.mage.Mage;
import org.battlearena.exceptions.ExceededActionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Jane Doe", new Mage());
    }

    @Test
    void increaseActionCountIncreasesTheCount() {
        int actualBeforeIncrease = player.getActionCount();
        assertEquals(0, actualBeforeIncrease);

        assertDoesNotThrow(() -> {
            player.increaseActionCount();
        });
        int actualAfterIncrease = player.getActionCount();
        assertEquals(1, actualAfterIncrease);

        assertDoesNotThrow(() -> {
            player.increaseActionCount();
        });
        int actualAfterAnotherIncrease = player.getActionCount();
        assertEquals(2, actualAfterAnotherIncrease);
    }

    @Test
    void increaseActionCountThrowsExceptionIfMoreThanTwoActions() {
        int actualBeforeIncrease = player.getActionCount();
        assertEquals(0, actualBeforeIncrease);

        assertThrows(ExceededActionException.class, () -> {
            player.increaseActionCount();
            player.increaseActionCount();
            player.increaseActionCount();
        });
        int actualAfterIncrease = player.getActionCount();
        assertEquals(2  , actualAfterIncrease);
    }

    @Test
    void displayPlayerStatusInfoShouldReturnRightString(){ // player finns i klassen och behöver inte hämtas från game
        player.setHp(50);
        String expectedOutput = "The " +
                player.getPlayerCharacter().getClass().getSimpleName() +
                " played by " +
                player.getName() +
                " has " +
                player.getHp() + "HP.";
                //" HP remaining and has the following effects: "

        assertEquals(expectedOutput, player.displayPlayerStatusInfo());
    }
}