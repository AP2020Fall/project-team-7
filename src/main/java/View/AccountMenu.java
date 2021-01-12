package View;

import Controller.Manager;

public class AccountMenu extends Menu {
    public AccountMenu(Manager manager) {
        super(manager);
        System.out.println("1. Register\n" +
                "2. Login\n" +
                "3. exit");
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("^1$")) {
                System.out.println("R");
                break;
            } else if (input.matches("^2$")) {
                System.out.println("L");
                break;
            } else if (input.matches("^3$")) {
                System.exit(1);
                break;
            } else {
                System.err.println("invalid input.");
            }
        }
    }
}

