package org.battlearena.turns;

import org.battlearena.Game;
import org.battlearena.characters.mage.Mage;
import org.battlearena.player.CharacterCreator;
import org.battlearena.player.Player;
import org.battlearena.player.PlayerStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ResultsTest {
    Scanner scanner;
    CharacterCreator characterCreator;
    Results results;

    @BeforeEach
    void setUp() {
        this.scanner = new Scanner(System.in);
        this.characterCreator = new CharacterCreator(this.scanner);
        this.results = new Results();
        Player humanPlayer = new Player("TestNameHuman", new Mage());
        Player computerPlayer = new Player("TestNameComputer", new Mage());
        characterCreator.addPlayer(humanPlayer);
        characterCreator.addPlayer(computerPlayer);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void alivePlayersCheckShouldReturnFalseWhenAPlayerDies() {
        characterCreator.getPlayers().getFirst().setHp(0);
        results.alivePlayersCheck(characterCreator.getPlayers());
        assertFalse(results.alivePlayersCheck(characterCreator.getPlayers()));
    }

    @Test
    void assignWinnerCheckShouldReturnRightEnum() {
        characterCreator.getPlayers().getFirst().setHp(0);
        results.assignWinner(characterCreator.getPlayers());
        assertEquals(PlayerStatus.LOSER, characterCreator.getPlayers().getFirst().getPlayerStatus());
    }
}