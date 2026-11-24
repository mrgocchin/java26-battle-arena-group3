package org.battlearena.turns;

import org.battlearena.Prompter;
import org.battlearena.actions.attack.Attack;
import org.battlearena.actions.defend.Defend;
import org.battlearena.actions.heal.Heal;
import org.battlearena.actions.specialskill.SpecialSkill;
import org.battlearena.exceptions.ExceededActionException;
import org.battlearena.exceptions.InvalidInputException;
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

    public static int getTurnCount() {
        return turnCount;
    }

    public void setFirstPlayer(Player player) {
        firstPlayer = player;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void setSecondPlayer(Player player) {
        secondPlayer = player;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public int getRoundsRemaining() {
        return roundsRemaining;
    }

    public List<Actionable> getPerformedActions(){
        return performedActions;
    }

    public void addPerformedAction(Actionable action) {
        performedActions.add(action);
    }

    public void decreaseRounds() {
        if (roundsRemaining == 0) {
            return;
        }
        roundsRemaining--;
    }

    public void play() {
        for (int i = 0; i <= getRoundsRemaining(); i++) {
            try {
                turnActions(firstPlayer, secondPlayer);
                turnActions(secondPlayer, firstPlayer);
                decreaseRounds();
            } catch (ExceededActionException e) {
                // TODO this needs better handling
                System.out.println(e.getMessage());
            }
        }
    }

    protected void turnActions(Player player, Player opponent) throws ExceededActionException {
        /*
            Scenarios:
                Round 1: Neither player has attacked yet -- OK!
                Round 2: Player might have attacked, so now we need to check on that:
                    a) Player has attacked: Exclude Attack from options -- OK!
                    b) Player has _not_ attacked: Don't prompt player to select action, just force the attack. -- TODO
         */
        if(player.getHp() <= 0){
            return;
        }

        if (! player.hasRemainingActions()) {
            throw new ExceededActionException("Player " + player.getName() + " has already used up their actions this turn");
        }

        Actionable action = null;
        while (action == null) {
            try {
                // if player is human
                String input = Prompter.promptForAction(player.hasAttackedThisTurn());
                action = selectAction(input, player, opponent);
                // else, player is computer. Then we need to randomly pick an action for the computer
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                System.out.print("Do you want to quit? (Y/N): ");
                Prompter.promptQuitGame();
            }
        }

        action.perform();

        System.out.println(action.getDescription());
        addPerformedAction(action);
        player.increaseActionCount();
    }

    public Actionable selectAction(String input, Player player, Player opponent) throws InvalidInputException, ExceededActionException {
        switch (input.toLowerCase().trim()) {
            case "attack":
                if (player.hasAttackedThisTurn()) {
                    throw new ExceededActionException("You have already attacked this turn! Please select a different action.");
                }
                return new Attack(player, opponent);
            case "defend":
                return new Defend(player, opponent);
            case "heal":
                return new Heal(player);
            case "special":
                return new SpecialSkill();
            default:
                throw new InvalidInputException("Sorry, we don't have such an action. Please type either of: Attack, Defend or Special");
        }
    }
}
