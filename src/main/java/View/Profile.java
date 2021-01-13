package View;

import Controller.Manager;
import Controller.ProfileManager;

public class Profile extends Menu {
    public Profile(Manager manager) {
        super(manager);
        System.out.println("Enter 3 to go to Main page!" +
                "username: " + "\n" +
                "plato age: " + 0 + "\n" +
                "friends: " + 0 + "\n" +
                "score: " + 0 + "\n" +
                "1. view personal info\n" +
                "2. delete Account\n" +
                "3. Main page");
        while (true) {
            String input = scanner.nextLine();
//            if ((!input.matches("^1$")) || (!input.matches("^2$")) || (!input.matches("^3$"))) {
//                System.err.println("invalid input! enter back to return profile or 3 to go Main page:");
//                continue;
//            } else {
                if (input.matches("^1$")) {
                    System.out.println("view personal info:");
                    ((ProfileManager) manager).showPersonalInfo();
                    System.out.println("enter back to return profile or enter 3 to back to Main page: ");
                    input = scanner.nextLine();
                    while (!input.matches("^back$ || ^3$")){
                        System.out.println("enter back to return profile or enter 3 to back to Main page: ");
                        input = scanner.nextLine();
                    }
                    if (input.equalsIgnoreCase("back")) {
                        goProfile();
                    } else if (input.matches("^3$")) {
                        returnMainPage();
                    }
                    break;
                } else if (input.matches("^2$")) {
                    System.out.println("delete account:");
                    System.out.println("username:");
                    String username = scanner.nextLine();
                    if (username.equalsIgnoreCase("back")) {
                        goProfile();
                    }
                    System.out.println("password:");
                    String password = scanner.nextLine();
                    while (!((ProfileManager) manager).canDeleteAccount(username, password)) {
                        System.err.println("username or password is wrong!");
                        System.out.println("username:");
                        username = scanner.nextLine();
                        if (username.equalsIgnoreCase("back")) {
                            goProfile();
                        }
                        System.out.println("password:");
                        password = scanner.nextLine();
                        ((ProfileManager) manager).canDeleteAccount(username, password);
                    }
                    System.out.println("account " + username + " deleted!");
                    break;

                } else {
                    returnMainPage();
                }
            }
//        }
    }
}
