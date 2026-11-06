package org.battlearena.characters.necromancer;

public enum NecromancerStats {
    MAX_HP(100),
    MIN_HP(0),
    MIN_ATTACK_DAMAGE(3),
    MAX_ATTACK_DAMAGE(12),
    MIN_DEFEND(1),
    MAX_DEFEND(5);

    public final int value;

    NecromancerStats(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
