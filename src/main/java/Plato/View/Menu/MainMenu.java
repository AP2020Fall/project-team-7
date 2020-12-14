package Plato.View.Menu;

import Plato.View.Menu.Menu;

import java.util.HashMap;

public class MainMenu extends Menu {
    public MainMenu() {
        super("Main Menu", null);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, new RegisterMenu(this));
        submenus.put(2, new LoginMenu(this));
        submenus.put(3, new UserProfile(this));
        this.setSubmenus(submenus);
    }
}