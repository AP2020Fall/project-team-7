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
            if (input.matches("^1$")) {
                System.out.println("view personal info:");
                //show personal info. can't get current user
                System.out.println("personal info sample\n" +
                        "2. edit personal info\n" +
                        "3. Main page\n" +
                        "press any key to back!");
                input = scanner.nextLine();
                if (input.matches("^2$")) {
                    System.out.println("edit info");
                } else if (input.matches("^3$")) {
                    returnMainPage();
                } else {
                    goProfile();
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

            } else if (input.matches("^3$")) {
                returnMainPage();
                break;
            }
            else
                System.err.println("invalid command!");
        }
//        }
    }
}
