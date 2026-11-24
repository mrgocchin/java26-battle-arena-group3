package org.battlearena;

import org.battlearena.characters.mage.Mage;
import org.battlearena.player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.util.Scanner;



class GameTest {
    Scanner scanner;
    Game game;

    @BeforeEach
    void setUp() {
        this.scanner = new Scanner(System.in);
        this.game = new Game(this.scanner);
        Player humanPlayer = new Player("TestNameHuman", new Mage());
        Player computerPlayer = new Player("TestNameComputer", new Mage());
    }

    @AfterEach
    void tearDown() {
    }

}
