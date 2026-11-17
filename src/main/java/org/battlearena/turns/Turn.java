package org.battlearena.turns;

import org.battlearena.player.Player;
import org.battlearena.actions.Actionable;
import java.util.ArrayList;
import java.util.List;

public class Turn {
    private static int turnCount = 0;
    private int roundsRemaining = 2;
    private Player firstPlayer;
    private Player secondPlayer;

    private ArrayList<Actionable> performedActions;

    public Turn() {
        this.performedActions = new ArrayList<>();

        turnCount++;
    }

    private void decreaseRounds() {
        if (roundsRemaining == 0) {
            return;
        }
        roundsRemaining--;
    }

    public void performAction(Actionable action) /*throws ExceededActionException*/{
        action.perform();
        System.out.println(action.getDescription());
        performedActions.add(action);
    }

    public List<Actionable> getPerformedActions(){
        return performedActions;
    }
}
