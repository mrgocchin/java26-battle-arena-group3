package org.battlearena;

import org.battlearena.characters.mage.Mage;
import org.battlearena.player.Player;
import org.battlearena.player.PlayerStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}