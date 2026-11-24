package org.battlearena.player;
import org.battlearena.characters.Character;
import org.battlearena.characters.mage.Mage;
import org.battlearena.characters.necromancer.Necromancer;
import org.battlearena.characters.warrior.Warrior;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class CharacterCreator {

    private Scanner scanner;
    private Random random;
    private ArrayList <Player> players;
    private ArrayList <Character> availableCharacters;

    public CharacterCreator(Scanner scanner){
        this.scanner = scanner;
        this.random = new Random();
        this.players = new ArrayList<>();
        this.availableCharacters = new ArrayList<>();
        availableCharacters.add(new Warrior());
        availableCharacters.add(new Mage());
        availableCharacters.add(new Necromancer());
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    private Player getComputerPlayer() {
        return new Player("Computer player", getComputerPlayerCharacter());
    }

    private Character getComputerPlayerCharacter() {
        int randomNumber = random.nextInt(3);
        if (randomNumber == 0) {
            return new Warrior();
        } else if (randomNumber == 1) {
            return new Mage();
        } else {
            return new Necromancer();
        }
    }

    private Player getHumanPlayer(){
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Character selectedCharacter = null;
        while (selectedCharacter == null) {
            System.out.print("Your choice of character? (Warrior/ Mage / Necromancer): ");
            if (scanner.hasNextLine()) {
                String chosenCharacter = scanner.nextLine();
                for (Character c : availableCharacters) {
                    if (chosenCharacter.trim().equalsIgnoreCase(c.getClass().getSimpleName())) {
                        System.out.println("You have chosen the character " + c.getClass().getSimpleName() + " and your name is: " + name);
                        selectedCharacter = c;
                        System.out.println("The computer got the character: " + selectedCharacter.getClass().getSimpleName());
                        break;
                    }
                }
            }
            if (selectedCharacter == null) {
                System.out.println("You have to type in a valid character, do you want to quit? (Y/N)");
                promptQuitGame();
            }
        }
        Player humanPlayer = new Player(name, selectedCharacter);
        humanPlayer.setIsHuman();   
        return humanPlayer;
    }

    public void promptQuitGame() {
        String response = scanner.nextLine();
        if (response.trim().equalsIgnoreCase("Y")) {
            System.exit(0);
        }
    }

    public ArrayList<Player> getPlayers(){
        if(players.isEmpty()){
            addPlayer(getHumanPlayer());
            addPlayer(getComputerPlayer());
        }
        return players;
    }

}
