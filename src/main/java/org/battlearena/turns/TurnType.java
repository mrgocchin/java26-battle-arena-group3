package org.battlearena.turns;

public enum TurnType {

    FIRST_ROUND(),
    LAST_ROUND(), 
    OUT_OF_ROUNDS();

    private TurnType(){
    }

    public boolean isOutOfRounds(){
        return this == OUT_OF_ROUNDS;
    }

}
