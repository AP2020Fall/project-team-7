package View;

import Controller.Manager;
import Controller.ProfileManager;
import Model.Person;

public class Profile extends Menu {
    Person person = Manager.getCurrentPlayer();

    public Profile(Manager manager) {
        super(manager);
        showProfile();
    }

    private void showProfile() {
        System.out.println("" +
                "Enter 3 to go to Main page!\n" +
                "username: " + person.getUsername() + "\n" +
                "plato age: " + Manager.getCurrentPlayer().getPlatoAge() + "\n" +
                "friends: " + Manager.getCurrentPlayer().getFriendList().size() + "\n" +
                "score: " + Manager.getCurrentPlayer().getScore() + "\n" +
                "1. view personal info\n" +
                "2. delete Account\n" +
                "3. Main page");

        String input = scanner.nextLine();
        if (input.matches("^1$")) {
            viewPersonalInfo();

        } else if (input.matches("^2$")) {
            deleteAccount();

        } else if (input.matches("^3$")) {
            returnMainPage();
        } else {
            System.err.println("invalid command!");
            showProfile();
        }

    }

    private void viewPersonalInfo() {
        System.out.println("view personal info:");
        System.out.println(Manager.getCurrentPlayer().toString());
        System.out.println("" +
                "2. edit personal info\n" +
                "3. Main page\n" +
                "press any key to back!");
        String input = scanner.nextLine();
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
                "edit info:\n" +
                "1. change password\n" +
                "2. change first name\n" +
                "3. change last name\n" +
                "4. change Email\n" +
                "5. change phone number\n" +
                "6. back");

        String input = scanner.nextLine();
        if (input.matches("^1$")) {
            changePassword();

        } else if (input.matches("^2$")) {
            input = scanner.nextLine();
            ((ProfileManager)manager).changeFName(input);
            System.out.println("your first name changed to " + input);
            viewPersonalInfo();
        } else if (input.matches("^3$")) {
            input = scanner.nextLine();
            ((ProfileManager)manager).changeLName(input);
            System.out.println("your last name changed to " + input);
            viewPersonalInfo();
        } else if (input.matches("^4$")) {
            changeEmail();

        } else if (input.matches("^5$")) {
            changePhoneNum();

        } else if (input.matches("^6$")) {
            viewPersonalInfo();

        } else {
            System.err.println("invalid command!");
            editInfo();
        }
    }

    private void changePassword() {
        System.out.println("" +
                "enter your current password:\n" +
                "or enter 'back' to return");
        String currentPassword = scanner.nextLine();
        if (currentPassword.equalsIgnoreCase("back")){
            editInfo();
        }
        if (manager.isThisPasswordCorrect(currentPassword)){
            currentPassword = scanner.nextLine();
            ((ProfileManager)manager).changePassword(currentPassword);
            System.out.println("your password changed successfully.");
            viewPersonalInfo();
        } else {
            System.err.println("wrong password!");
            changePassword();
        }
    }

    private void changeEmail() {
        System.out.println("enter your new email\n" + "or enter 'back' to return");
        String email = scanner.nextLine();
        if (email.equalsIgnoreCase("back")){
            editInfo();
        }
        if (manager.checkEmail(email)){
            ((ProfileManager)manager).changeEmail(email);
            System.out.println("your email changed to " + email);
            viewPersonalInfo();
        } else {
            System.err.println("invalid input!");
            changeEmail();
        }
    }

    private void changePhoneNum() {
        System.out.println("enter your new phone number\n" + "or enter 'back' to return");
        String phoneNum = scanner.nextLine();
        if (phoneNum.equalsIgnoreCase("back")){
            editInfo();
        }
        if (manager.checkPhoneNumber(phoneNum)){
            ((ProfileManager)manager).changePhoneNum(phoneNum);
            System.out.println("changed phone number to " + phoneNum);
            viewPersonalInfo();
        } else {
            System.err.println("invalid input!");
            changePhoneNum();
        }
    }

    private void deleteAccount() {
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
        logout();
    }
}
