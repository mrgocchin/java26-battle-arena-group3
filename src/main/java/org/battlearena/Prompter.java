package org.battlearena;

import java.util.Scanner;

public final class Prompter {
    static Scanner scanner = new Scanner(System.in);

    public static String promptForAction(boolean excludeAttack) {
        if (excludeAttack) {
            System.out.print("What would you like to do? (Defend / Heal / Special): ");
        } else {
            System.out.print("What would you like to do? (Attack / Defend / Heal / Special): ");
        }

        return scanner.nextLine();
    }

    public static void promptQuitGame() {
        String response = scanner.nextLine();
        if (response.trim().equalsIgnoreCase("Y")) {
            System.exit(0);
        }
    }
}
