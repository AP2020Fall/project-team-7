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
                    this.show();
                    this.execute();
                }
            }
        };
    }
}
