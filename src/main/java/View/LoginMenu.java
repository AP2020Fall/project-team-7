package View;

import Controller.AccountManager;
import Controller.LoginManager;
import Controller.Manager;

public class LoginMenu extends Menu {
    public LoginMenu(Manager manager) {
        super(manager);
        System.out.println("username:");
        String username = scanner.nextLine();
        if (username.equalsIgnoreCase("back")) {
            returnBack();
        }

        System.out.println("password:");
        String password = scanner.nextLine();
        while (!((LoginManager) manager).loginUser(username, password)) {
            System.err.println("username or password is wrong! try again or back to register!");
            System.out.println("username:");
            username = scanner.nextLine();
            if (username.equalsIgnoreCase("back")) {
                returnBack();

            }
            System.out.println("password:");
            password = scanner.nextLine();
            if (password.equalsIgnoreCase("back")) {
                returnBack();
            }
        }
        System.out.println("welcome " + username);
    }

}
