package View;

import Controller.AccountManager;
import Controller.LoginManager;
import Controller.Manager;

public class LoginMenu extends Menu {
    public LoginMenu(Manager manager) {
        super(manager);
        System.out.println("username:");
        String username = scanner.nextLine();
        System.out.println("password:");
        String password = scanner.nextLine();
        while (!((LoginManager) manager).loginUser(username, password)) {
            System.err.println("username or password is wrong! try again or back to register!");
            if (username.equalsIgnoreCase("back")) {
                ((AccountManager) manager).execute();

            } else {
                System.out.println("username:");
                username = scanner.nextLine();
            }
            if (password.equalsIgnoreCase("back")) {
                ((AccountManager) manager).execute();

            } else {
                System.out.println("password:");
                password = scanner.nextLine();
            }
        }
        System.out.println("welcome " + username);
    }
}
