package View;

import Controller.Manager;
import Controller.RegisterManager;

public class RegisterMenu extends Menu{
    public RegisterMenu(Manager manager) {
        super(manager);
        System.out.println("username:");
        String username = scanner.nextLine();
        System.out.println("password:");
        String password = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        while (!manager.checkEmail(email)){
            System.err.println("invalid input, try again!");
            email = scanner.nextLine();
        }
        System.out.println("first name:");
        String fName = scanner.nextLine();
        System.out.println("last name:");
        String lName = scanner.nextLine();
        System.out.println("phone number:");
        String phoneNum = scanner.nextLine();
        while (!manager.checkPhoneNumber(phoneNum)){
            System.err.println("invalid input, try again!");
            phoneNum = scanner.nextLine();
        }
        ((RegisterManager) manager).createNewAccount(username, password, email, fName, lName, phoneNum);
//        System.out.println(((RegisterManager) manager).createNewAccount(username, password, email, fName, lName, phoneNum));
        System.out.println("hello " + fName);
    }

}
