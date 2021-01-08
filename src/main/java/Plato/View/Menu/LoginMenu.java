package Plato.View.Menu;

import java.util.HashMap;

public class LoginMenu extends Menu {
    private boolean isCorrectUser;

    public LoginMenu(Menu parentMenu) {
        super("login", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, loginToAccount());
        this.setSubmenus(submenus);
        isCorrectUser = false;

    }

    private Menu loginToAccount() {
        return new Menu("login page", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("enter username and password");
                System.out.println("if you have not account back and register!");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    String[] splitInput = input.split("\\s+");
                    for (String user : manager.getUser().keySet()) {
                        if ((manager.getUser().keySet().equals(splitInput[0])) &&
                                (manager.getUser().get(user).equals(splitInput[1]))) {
                            isCorrectUser = true;
                            System.out.println("login successfully!");
                        } else {
                            System.err.println("username or password is wrong!");
                            this.show();
                            this.execute();
                        }
                    }

                }
            }
        };
    }
}
