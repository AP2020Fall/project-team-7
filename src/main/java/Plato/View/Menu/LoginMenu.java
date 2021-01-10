package Plato.View.Menu;

import Plato.Model.Player;

import java.util.HashMap;

public class LoginMenu extends Menu {
    private UserProfile userProfile;

    public LoginMenu(Menu parentMenu) {
        super("login", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, loginToAccount());
        this.setSubmenus(submenus);
        userProfile = new UserProfile("profile", parentMenu);

    }

    private Menu loginToAccount() {
        return new Menu("login page", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("enter username:");
                System.out.println("if you have not account back and register!");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    for (Player user : manager.getAllUsers()) {
                        if (input.equals(user)){
                            break;
                        } else {
                            System.err.println("this username is not exist!");
                            this.show();
                            this.execute();
                        }
                    }
                    System.out.println("enter password:");
                    String password = scanner.nextLine();
                    if (manager.getUser().get(input).equals(password)){
                        userProfile.show();
                        userProfile.execute();
                    }
                    System.err.println("wrong password!");
                    this.show();
                    this.execute();



//                    String[] splitInput = input.split("\\s+");
//                    for (String user : manager.getUser().keySet()) {
//                        if ((manager.getUser().keySet().equals(splitInput[0])) &&
//                                (manager.getUser().get(user).equals(splitInput[1]))) {
//                            isCorrectUser = true;
//                            new MainPage(null);
//                            System.out.println("login successfully!");
//                        } else {

//                        }
//                    }

                }
            }
        };
    }
}
