package org.battlearena;

import org.battlearena.player.CharacterCreator;
import org.battlearena.player.Player;
import org.battlearena.turns.Results;
import org.battlearena.turns.Turn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private CharacterCreator characterCreator;
    private ArrayList<Player> players;
    private Results results;

    public Game(Scanner scanner) {
        this.players = new ArrayList<>();
        this.characterCreator = new CharacterCreator(scanner);
        this.results = new Results();
    }

    public void run() {
        this.players = characterCreator.getPlayers();

        playGame();
    }

    private void playGame() {
        do {
            playTurn();
        } while (!isGameOver());

        System.out.println(results.assignWinner(players));
    }

    private void playTurn() {
        Turn turn = new Turn();

        Collections.shuffle(players);
        Player firstPlayer = players.getFirst();
        Player secondPlayer = players.getLast();
        firstPlayer.setHasAttackedThisTurn(false);
        secondPlayer.setHasAttackedThisTurn(false);

        turn.setFirstPlayer(firstPlayer);
        turn.setSecondPlayer(secondPlayer);
        turn.play();
        System.out.println("Turn " + Turn.getTurnCount() + " has ended");
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    private boolean isGameOver() {
        return !results.alivePlayersCheck(players);
    }
}
