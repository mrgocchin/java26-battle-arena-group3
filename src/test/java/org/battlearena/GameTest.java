package org.battlearena;

import org.battlearena.actions.Actionable;
import org.battlearena.actions.attack.Attack;
import org.battlearena.characters.mage.Mage;
import org.battlearena.exceptions.InvalidInputException;
import org.battlearena.player.Player;
import org.battlearena.player.PlayerStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Scanner scanner;
    Game game;

    @BeforeEach
    void setUp() {
        this.scanner = new Scanner(System.in);
        this.game = new Game(this.scanner);
        Player humanPlayer = new Player("TestNameHuman", new Mage());
        Player computerPlayer = new Player("TestNameComputer", new Mage());
        game.addPlayer(humanPlayer);
        game.addPlayer(computerPlayer);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Disabled
    void runShouldNotCrash() {
        this.game.run();
    }

    @Test
    void alivePlayersCheckShouldReturnFalseAPlayerDies() {
        game.getPlayers().getFirst().setHp(0);
        game.alivePlayersCheck();
        assertFalse(game.alivePlayersCheck());

    }



    @Test
    void assignWinnerCheckShouldReturnRightEnum() {

        game.getPlayers().getFirst().setHp(0);
        game.assignWinner();
        assertEquals(PlayerStatus.LOSER, game.getPlayers().getFirst().getPlayerStatus());
    }

    @Test
    void displayPlayerStatusInfoShouldReturnRightString(){
        Player player = game.getPlayers().getFirst();
        player.setHp(50);
        String expectedOutput = "The " +
                player.getPlayerCharacter().getClass().getSimpleName() +
                " played by " +
                player.getName() +
                " has " +
                player.getHP() + "\n";
                //" HP remaining and has the following effects: "

        assertEquals(expectedOutput, game.displayPlayerStatusInfo(player));
    }

    @Test
    void selectActionShouldReturnActionAtValidInput() {
        Actionable expected = new Attack();

        assertDoesNotThrow(() -> {
            Actionable actual = game.selectAction("attack");
            assertNotNull(actual);
            assertEquals(expected.getClass(), actual.getClass());
        });

    }

    @Test
    void selectActionShouldThrowExceptionAtInValidInput() {
        assertThrows(InvalidInputException.class, () -> {
           game.selectAction("loiter");
        });
    }
}