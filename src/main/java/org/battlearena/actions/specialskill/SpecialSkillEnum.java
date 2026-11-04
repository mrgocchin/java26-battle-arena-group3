package org.battlearena.actions.specialskill;

import org.battlearena.actions.Actionable;

public enum SpecialSkillEnum {HEALING("Healing", 10),
    FIREBALL("Fireball", 16);

public final String name;
public final int value;

SpecialSkillEnum(String name, int value){

    this.value = value;
    this.name = name;}

}


