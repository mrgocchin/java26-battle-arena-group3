package org.battlearena.player;

import org.battlearena.actions.Effect;
import org.battlearena.characters.Character;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private int hp;
    private Character playerCharacter;
    private WinningStatus winningStatus = WinningStatus.STILL_PLAYING;

    private Map<String, Effect> effects = new HashMap<>();

    public Player(String name, Character playerCharacter) {
        this.name = name;
        this.playerCharacter = playerCharacter;
        this.hp = playerCharacter.getMaxHp();
    }

    public int getHP() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public WinningStatus getWinningStatus() {
        return winningStatus;
    }

    public void setWinningStatus(WinningStatus winningStatus) {
        this.winningStatus = winningStatus;
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
}
