package org.battlearena;

import org.battlearena.characters.mage.Mage;
import org.battlearena.player.Player;
import org.battlearena.player.WinningStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void winnerCheckShouldReturnCorrectEnum() {
        ArrayList<Player> players = game.getPlayers();
        players.getFirst().setHp(0);
        game.winningStatusCheck(game.getPlayers());
        assertEquals(WinningStatus.LOSER, players.getFirst().getWinningStatus());




    }
}