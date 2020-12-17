package Plato.View.Menu;

import Plato.Controller.Manager;
import Plato.Controller.PlatoBotController;
import Plato.Model.Player;

import java.util.HashMap;

public class RegisterMenu extends Menu {
    private String username;
    private String password;
    PlatoBotController platoBotController;


    public RegisterMenu(Menu parentMenu) {
        super("Register", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, createNewAccount());
        this.setSubmenus(submenus);
        platoBotController = new PlatoBotController();
    }

    private Menu createNewAccount() {
        return new Menu("Register menu", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("enter username and password");
                System.out.println("if you have account back and login!");
            }

            @Override
            public void execute() {
//                String username = scanner.nextLine();
//                String password = scanner.nextLine();
                String input = scanner.nextLine();
                scanner.nextLine();
                username = input.split("\\s+")[0];
                password = input.split("\\s+")[1];

                if (username.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    if (manager.getAllUsers().isEmpty()) {
                        System.out.println("complete your profile.");
                        completeProfile(username, password);
                    } else {
                        for (Player allUser : manager.getAllUsers()) {
                            if (allUser.getUsername().equalsIgnoreCase(username)) {
                                System.out.println("this Id is already taken!");
                                execute();
                            } else {
                                System.out.println("registration successfully!\n" +
                                        "complete your profile.");
//                                completeProfile(username, password);
                                break;
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
        while (!platoBotController.checkEmail(Email)) {
            System.out.println("your Email is not valid. please enter your Email: ");
            Email = scanner.nextLine();
        }
        System.out.println("Enter your id: ");
        id = scanner.nextLine();
        System.out.println("Enter your phone: ");
        phoneNum = scanner.nextLine();
        while (!platoBotController.checkPhoneNumber(phoneNum)) {
            System.out.println("your phone number is not valid. please enter your phone");
            phoneNum = scanner.nextLine();
        }
        Player player = new Player(firstName, lastName, username, id, password, Email, phoneNum);
        manager.registerUser(player);
        System.out.println("register successfully!");
    }


}
