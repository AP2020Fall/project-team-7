package Plato.View.Menu;

import java.util.HashMap;

public class LoginMenu extends Menu {
    public LoginMenu(Menu parentMenu) {
        super("login", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, loginToAccount());
        this.setSubmenus(submenus);

    }

    private Menu loginToAccount() {
        return new Menu("login page", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("enter username");
                System.out.println("if you have not account back and register!");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    System.out.println("enter your password");
                    String password = scanner.nextLine();
                    for (String user : manager.getUser().keySet()) {
                        if (manager.getUser().get(user).equals(password)){
                            System.out.println("login successfully!");
                        } else {
                            System.out.println("username or password is wrong!");
                            this.show();
                            this.execute();
                        }
                    }

                }
            }
        };
    }
}
