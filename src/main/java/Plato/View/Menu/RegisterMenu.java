package Plato.View.Menu;

import Plato.Controller.Manager;
import Plato.Model.Player;

import java.util.HashMap;

public class RegisterMenu extends Menu {
    private String username;
    private String password;


    public RegisterMenu(Menu parentMenu) {
        super("Register", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, createNewAccount());
        this.setSubmenus(submenus);

    }

    private Menu createNewAccount() {
        return new Menu("register", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("if you have account back and login!");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    String[] splitInput = input.split("\\s+");
                    if (manager.getAllUsers().size()==0) {
                        System.out.println("registration successfully!\n" +
                                "complete your profile.");
                        completeProfile(splitInput[0], splitInput[1]);
                    } else {
                        for (Player allUser : manager.getAllUsers()) {
                            if (allUser.getUsername().equalsIgnoreCase(splitInput[0])) {
                                System.out.println("this Id is already taken!");
                                execute();
                            } else {
                                System.out.println("registration successfully!\n" +
                                        "complete your profile.");
                                completeProfile(splitInput[0], splitInput[1]);
                            }
                        }
                    }
                    this.show();
                    this.execute();
                }
            }
        };
    }

    public void completeProfile(String username, String password) {
        String Email, phoneNum, firstName, lastName, id;
        System.out.println("Enter your first name: ");
        firstName = scanner.nextLine();
        System.out.println("Enter your last name: ");
        lastName = scanner.nextLine();
        System.out.println("Enter your Email: ");
        Email = scanner.nextLine();
        while (!checkEmail(Email)) {
            System.out.println("your Email is not valid. please enter your Email: ");
            Email = scanner.nextLine();
        }
        System.out.println("Enter your id: ");
        id = scanner.nextLine();
        System.out.println("Enter your phone: ");
        phoneNum = scanner.nextLine();
        while (!checkPhoneNumber(phoneNum)) {
            System.out.println("your phone number is not valid. please enter your phone");
            phoneNum = scanner.nextLine();
        }
        Player player = new Player(firstName, lastName, username, id, password, Email, phoneNum);
        manager.registerUser(player);
        System.out.println("register successfully!");
    }


}
