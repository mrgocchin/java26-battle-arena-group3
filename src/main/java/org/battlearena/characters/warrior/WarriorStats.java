package org.battlearena.characters.warrior;

public enum WarriorStats {
    MAX_HP(100),
    MIN_HP(0),
    MIN_ATTACK_DAMAGE(3),
    MAX_ATTACK_DAMAGE(12),
    MIN_DEFEND(3),
    MAX_DEFEND(7);

    //moved special skills and healing will need to a different enum with all special skills.


    public final int value;
    WarriorStats(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
