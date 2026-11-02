package org.battlearena;

import org.battlearena.characters.entities.Mage;
import org.battlearena.player.Player;

import java.util.Scanner;

public class Game {
    private Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        // The following three lines are simple health checks and needs to be removed once we get really started.
        IO.println("Shall we play a game?");
        Player player = new Player("Testing", new Mage());

        // Handle or delegate input/output here
    }
}
