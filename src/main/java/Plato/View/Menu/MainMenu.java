package Plato.View.Menu;

import Plato.View.Menu.Menu;

import java.util.HashMap;

public class MainMenu extends Menu {
    public MainMenu() {
        super("Main Menu", null);
        HashMap<Integer, Menu> submenus = new HashMap<>();
//        submenus.put(1, new StudentMenu(this));
        this.setSubmenus(submenus);
    }
}