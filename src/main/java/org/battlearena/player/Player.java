package org.battlearena.player;

import org.battlearena.actions.effects.Effect;
import org.battlearena.characters.Character;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private int hp;
    private Character playerCharacter;

    private Map<String, Effect> effects = new HashMap<>();

    public Player(String name, Character playerCharacter) {
        this.name = name;
        this.playerCharacter = playerCharacter;
        this.hp = playerCharacter.getMaxHp();
    }

    public int getHP() {
        return this.hp;
    }

    public Character getPlayerCharacter(){
        return this.playerCharacter;
    }

    public Map<String, Effect> getEffects() {
        return this.effects;
    }
}
