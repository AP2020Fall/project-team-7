package Plato.View;

import Plato.Controller.LoginManager;
import Plato.Controller.Manager;

public class LoginMenu extends Menu {
    public LoginMenu(Manager manager) {
        super(manager);
        showLoginMenu();
    }

    private void showLoginMenu() {
        System.out.println("login");
        System.out.println("username:");
        String username = scanner.nextLine();
        if (username.equalsIgnoreCase("back")) {
            returnAccountMenu();
        }
        System.out.println("password:");
        String password = scanner.nextLine();
        while (!((LoginManager) manager).canLoginUser(username, password)) {
            System.err.println("username or password is wrong! try again or back to register!");
            System.out.println("username:");
            username = scanner.nextLine();
            if (username.equalsIgnoreCase("back")) {
                returnAccountMenu();
            }
            System.out.println("password:");
            password = scanner.nextLine();
            if (password.equalsIgnoreCase("back")) {
                returnAccountMenu();
            }
        }
        System.out.println("welcome " + username);
        ((LoginManager) manager).loginUser(username);
    }
    //set user

}
