package org.battlearena.player;

import org.battlearena.actions.Effect;
import org.battlearena.characters.entities.Character;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private int hp;
    private Character playerCharacter;

    private Map<String, Effect> effect = new HashMap<>();

    public Player(String name, Character playerCharacter) {
        this.name = name;
        this.playerCharacter = playerCharacter;
        this.hp = playerCharacter.getHP();
    }

    public int getHP() {
        return this.hp;
    }
}
