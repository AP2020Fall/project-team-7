package Plato.View.Menu;

import Plato.Controller.Manager;
import Plato.Model.Player;

public class RegisterMenu extends Menu {
    private String username;
    private String password;


    public RegisterMenu(Menu parentMenu) {
        super("Register menu", parentMenu);
    }

    private Menu createNewAccount() {
        return new Menu("create account", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("If you have not an account creat one!\n" +
                        "Enter username and password:" +
                        "\nEnter back to return");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    String[] splitInput = input.split("\\s");
//                    manager.submitCourseMarkForStudent(splitInput[0], Float.parseFloat(splitInput[1]), splitInput[2]);
                    this.show();
                    this.execute();
                }
            }
        };
    }

    public void createNewAccount(String username, String password){
        String Email, phoneNum, firstName, lastName, id;
        System.out.println("Enter your first name: ");
        firstName = scanner.nextLine();
        System.out.println("Enter your last name: ");
        lastName = scanner.nextLine();
        System.out.println("Enter your Email: ");
        Email = scanner.nextLine();
        while (!checkEmail(Email)){
            System.out.println("your Email is not valid. please enter your Email: ");
            Email = scanner.nextLine();
        }
        System.out.println("Enter your id: ");
        id = scanner.nextLine();
        System.out.println("Enter your phone: ");
        phoneNum = scanner.nextLine();
        while (!checkPhoneNumber(phoneNum)){
            System.out.println("your phone number is not valid. please enter your phone");
            phoneNum = scanner.nextLine();
        }
        Player player = new Player(firstName, lastName, username, id, password, Email, phoneNum);
        manager.addPlayer(player);
        System.out.println("register successfully!");
    }
}
