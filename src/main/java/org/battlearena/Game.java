package org.battlearena;

import org.battlearena.characters.mage.Mage;
import org.battlearena.characters.necromancer.Necromancer;
import org.battlearena.characters.warrior.Warrior;
import org.battlearena.characters.Character;
import org.battlearena.player.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private ArrayList<Player> players;

    private Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void run() {
        // The following two lines are simple health checks and needs to be removed once we get really started.
        IO.println("Shall we play a game?");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        Character Warrior = new Warrior();
        Character Mage = new Mage();
        Character Necromancer = new Necromancer();
        ArrayList <Character> availableCharacters = new ArrayList<>();
        availableCharacters.add(Warrior);
        availableCharacters.add(Mage);
        availableCharacters.add(Necromancer);
        Character selectedCharacter = null;
        while(selectedCharacter == null){
            System.out.print("Your choice of character? (Warrior/ Mage / Necromancer): ");
            if(scanner.hasNextLine()){
                String chosenCharacter = scanner.nextLine();
                for(Character c : availableCharacters){
                    if(chosenCharacter.trim().equalsIgnoreCase(c.getClass().getSimpleName())){
                        System.out.println("You have chosen the character " + c.getClass().getSimpleName() + " and your name is: " + name);
                        selectedCharacter = c;
                        System.out.print("The computer got the character: " + selectedCharacter.getClass().getSimpleName());
                        break;
                    }   
                }
            }
            if(selectedCharacter == null){
                System.out.println("You have to type in a valid character, do you want to quit? (Y/N)");
                String response = scanner.nextLine();
                if(response.trim().equalsIgnoreCase("Y")){
                    break;
                }
            }
        }
        if (selectedCharacter != null) {
            Player humanPlayer = new Player(name, selectedCharacter);
            Player computerPlayer = getComputerPlayer();
            addPlayer(humanPlayer);
            addPlayer(computerPlayer);
        }
    }

    private Player getComputerPlayer(){
        return new Player("Computer player", getComputerPlayerCharacter());
    }

    private Character getComputerPlayerCharacter(){
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        if(randomNumber == 0) {
            return new Warrior();   
        }if(randomNumber == 1) {
            return new Mage();
        } else {
            return new Necromancer();
        }
    }

}
