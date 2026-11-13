package org.battlearena.player;

import org.battlearena.actions.Effect;
import org.battlearena.characters.Character;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private int hp;
    private Character playerCharacter;
    private boolean defending = false;
    private PlayerStatus playerStatus = PlayerStatus.PLAYING;
    //playerStatus enum instead of isAlive, so only one status at the time is possible.

    private Map<String, Effect> effects = new HashMap<>();

    public Player(String name, Character playerCharacter) {
        this.name = name;
        this.playerCharacter = playerCharacter;
        this.hp = playerCharacter.getMaxHp();
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public String winnerMessage() {
        return "Congratulations! " + this.name + " has won the game!" + "\nThe " + this.playerCharacter.getClass().getSimpleName() + " survived the battle!";
    }
    public String gameOverMessage() {
        return "Game Over! " + this.name + " has lost the game!" + "\nThe " + this.playerCharacter.getClass().getSimpleName() + " did not survive the battle!";
    }

    public Character getPlayerCharacter(){
        return this.playerCharacter;
    }

    public void setDefending() {
        this.defending = true;
    }

    public void setNotDefending() {
        this.defending = false;
    }

    public boolean isDefending() {
        return this.defending;
    }

    public String getName() {
        return name;
    }
}
