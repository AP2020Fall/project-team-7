package Plato.View.Menu;

import Plato.View.Menu.Menu;

import java.util.HashMap;

public class FirstPage extends Menu {
    public FirstPage() {
        super("Login or Register!", null);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, new RegisterMenu(this));
        submenus.put(2, new LoginMenu(this));
        this.setSubmenus(submenus);
    }
}