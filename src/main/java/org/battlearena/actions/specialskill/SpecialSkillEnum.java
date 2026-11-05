package org.battlearena.actions.specialskill;



public enum SpecialSkillEnum {
    WARD("Great ward", 10),
    STABILITY("Stability", 0),
    ADRENALINE("Adrenaline rush", 10),
    SHIELD_BASH("Shield bash", 5),
    DRAIN("Vampiric drain", 10),
    CURSE("Curse", 0);
    //SHIELD_BASH, DRAIN and ADRENALINE have effects to be added.

public final String name;
public final int value;

SpecialSkillEnum(String name, int value){
    this.name = name;
    this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}


