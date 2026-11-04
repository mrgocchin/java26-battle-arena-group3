package org.battlearena.characters.mage;

public enum MageStats {
    MAX_HP(100),
    MIN_HP(0),
    MIN_ATTACK_DAMAGE(3),
    MAX_ATTACK_DAMAGE(12);
    //moved special skills and healing will need to a different enum with all special skills.


    public final int value;

    MageStats(int value) {
        this.value = value;
    }

    public int getValue() {
         return this.value;
    }
}
