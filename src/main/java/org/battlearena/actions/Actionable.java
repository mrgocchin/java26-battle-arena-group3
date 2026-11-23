package org.battlearena.actions;

public interface Actionable {
    void perform();

    String getActionSummary();

    //to be removed
    String getDescription();
}
