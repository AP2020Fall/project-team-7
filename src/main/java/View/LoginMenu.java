package View;

import Controller.AdminPageManager;
import Controller.LoginManager;
import Controller.MainPageManager;
import Controller.Manager;
import Model.Person;

public class LoginMenu extends Menu {
    public LoginMenu(Manager manager) {
        super(manager);
        System.out.println("username:");
        String username = scanner.nextLine();
        if (username.equalsIgnoreCase("back")) {
            returnAccountMenu();
        }

        System.out.println("password:");
        String password = scanner.nextLine();
        while (!((LoginManager) manager).loginUser(username, password)) {
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
        if (Person.getPeople().get(0).equals(username)){
            manager = new AdminPageManager();
        }
        manager = new MainPageManager();
    }

}
