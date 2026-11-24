package org.battlearena;

import org.battlearena.actions.Actionable;
import org.battlearena.actions.attack.Attack;
import org.battlearena.actions.defend.Defend;
import org.battlearena.actions.heal.Heal;
import org.battlearena.actions.specialskill.SpecialSkill;
import org.battlearena.exceptions.ExceededActionException;
import org.battlearena.exceptions.InvalidInputException;
import org.battlearena.player.Player;
import org.battlearena.turns.Turn;
import org.battlearena.player.CharacterCreator;
import org.battlearena.turns.Results;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Game {
    private CharacterCreator characterCreator;
    private ArrayList<Player> players;
    private Scanner scanner;
    private Results results;

    public Game(Scanner scanner) {
        this.scanner = scanner;
        this.players = new ArrayList<>();
        this.characterCreator = new CharacterCreator(scanner);
        this.results = new Results();
    }


    public void run() {
        // The following two lines are simple health checks and needs to be removed once we get really started.
        IO.println("Shall we play a game?");
        this.players = characterCreator.getPlayers();
        playGame();
    }



    // NOTE: turnActions is pending removal after refactoring
    private void turnActions(Turn turn, Player player, Player opponent) {
        /*
            Scenarios:
                Round 1: Neither player has attacked yet
                Round 2: Player might have attacked, so now we need to check on that
         */
        // TODO check if player has used their two actions. If they have, prevent them from continuing here.
        if (! player.hasAttackedThisTurn()) {
            Actionable action = null;
            while (action == null) {
                try {
                    // if player is human
                    System.out.print("What would you like to do? (Attack / Defend / Special): ");
                    String input = scanner.nextLine();
                    action = selectAction(input, player, opponent);
                    // else, player is computer. Then we need to randomly pick an action for the computer
                } catch (InvalidInputException e) {
                    System.out.println(e.getMessage());
                    System.out.print("Do you want to quit? (Y/N): ");
                    Prompter.promptQuitGame();
                }
            }

            action.perform();

            System.out.println(action.getDescription());
            turn.addPerformedAction(action);
            try {
                player.increaseActionCount();
            } catch (ExceededActionException e) {
                // TODO this needs better handling
                System.out.println(e.getMessage());
            }
        } else {
            // Prompt for action (excluding attack)
            // After action completed, call turn.increaseActionCount()
        }
        // else force player to attack, they're not getting any other option
    } // end of method pending removal

    private void playGame(){ // Kör spelet
        do{ // anropa playTurn();
            playTurn();
        } while(! isGameOver()); // kör spelet så länge results.isGameOver() inte är sant.
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

        /*for (int i = 0; i <= turn.getRoundsRemaining(); i++) {
            turnActions(turn, firstPlayer, secondPlayer);
            turnActions(turn, secondPlayer, firstPlayer);
            turn.decreaseRounds();
        }*/
    }
    // NOTE: selectAction() is pending removal after refactoring
    public Actionable selectAction(String input, Player player, Player opponent) throws InvalidInputException {
        switch (input.toLowerCase().trim()) {
            case "attack":
                return new Attack(player, opponent);
             case "defend":
                return new Defend(player, opponent);
             case "heal":
                return new Heal(player);
            case "special":
                return new SpecialSkill();
            default:
                throw new InvalidInputException("Sorry, we don't have such an action. Please type either of: Attack, Defend or Special");
        }
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }

    private boolean isGameOver(){
        return !results.alivePlayersCheck(players);
    }   
}