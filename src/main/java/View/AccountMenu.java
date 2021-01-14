package View;

import Controller.LoginManager;
import Controller.Manager;
import Controller.RegisterManager;

public class AccountMenu extends Menu {
    public AccountMenu(Manager manager) {
        super(manager);
        showAccountMenu();
    }

    private void showAccountMenu() {
        System.out.println(
                "1. Register\n" +
                        "2. Login\n" +
                        "3. exit");
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("^1$")) {
                manager = new RegisterManager();
                break;
            } else if (input.matches("^2$")) {
                manager = new LoginManager();
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

