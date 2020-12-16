package Plato.View.Menu;

import java.util.HashMap;

public class LoginMenu extends Menu{
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
                System.out.println("If you have not an account create one!\n" +
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
                    this.show();
                    this.execute();
                }
            }
        };
    }
}
