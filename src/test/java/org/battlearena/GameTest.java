package org.battlearena;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class GameTest {
    Scanner scanner;
    Game game;

    @BeforeEach
    void setUp() {
        this.scanner = new Scanner(System.in);
        this.game = new Game(this.scanner);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void runShouldNotCrash() {
        this.game.run();
    }
}