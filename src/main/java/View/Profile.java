package View;

import Controller.Manager;
import Controller.ProfileManager;

public class Profile extends Menu {
    public Profile(Manager manager) {
        super(manager);
        showProfile();
    }

    private void showProfile(){
        System.out.println("" +
                "Enter 3 to go to Main page!" +
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
                viewPersonalInfo(input);

            } else if (input.matches("^2$")) {
                deleteAccount(input);

            } else if (input.matches("^3$")) {
                returnMainPage();
                break;
            } else
                System.err.println("invalid command!");
        }
    }
    private void viewPersonalInfo(String input) {
        System.out.println("view personal info:");
        //show personal info. can't get current user
        System.out.println("" +
                "personal info sample\n" +
                "2. edit personal info\n" +
                "3. Main page\n" +
                "press any key to back!");
        input = scanner.nextLine();
        if (input.matches("^2$")) {
            editInfo();

        } else if (input.matches("^3$")) {
            returnMainPage();
        } else {
            goProfile();
        }
    }

    private void editInfo() {
        System.out.println("" +
                "edit info:" +
                "1. change password\n" +
                "2. change first name\n" +
                "3. change last name\n" +
                "4. change Email\n" +
                "5. change phone number\n" +
                "6. back");
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("^1$")) {

                break;
            } else if (input.matches("^2$")) {

                break;
            } else if (input.matches("^3$")) {

                break;
            } else if (input.matches("^4$")) {

                break;
            } else if (input.matches("^5$")) {

                break;
            } else if (input.matches("^6$")) {

                break;
            }
            else
                System.err.println("invalid command!");
        }
    }

    private void deleteAccount(String input) {
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
    }
}
