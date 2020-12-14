package Plato.View;

import Plato.Controller.Manager;
import Plato.View.Menu.MainMenu;
import Plato.View.Menu.Menu;

import java.util.Scanner;

public class CommandProcessor {
    private Scanner scanner;
    private Manager manager;

    public CommandProcessor(Manager manager) {
        this.manager = manager;
        scanner = new Scanner(System.in);
    }

    public void run() {
        Menu.setScanner(this.scanner);
        Menu.setManager(this.manager);

        Menu currentMenu = new MainMenu();
        currentMenu.show();
        currentMenu.execute();
    }
}
