package org.battlearena.characters.mage;

public enum MageStats {
    HP(100),
    MIN_ATTACK_DAMAGE(3),
    MAX_ATTACK_DAMAGE(12);

    public final int value;

    MageStats(int value) {
        this.value = value;
    }

    public int getValue() {
         return this.value;
    }
}
