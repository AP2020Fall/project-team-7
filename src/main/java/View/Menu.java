package View;

import Controller.AccountManager;
import Controller.MainPageManager;
import Controller.Manager;
import Controller.ProfileManager;

import java.util.Scanner;

public class Menu {
    protected static Scanner scanner = new Scanner(System.in);
    protected Manager manager;

    public Menu(Manager manager) {
        this.manager = manager;
    }

    protected void returnAccountMenu() {
        new AccountManager();
    }

    protected void goProfile() {
        new ProfileManager();
    }

    protected void returnMainPage() {
        new MainPageManager();
    }

    protected void logout() {
        System.out.println("logout");
        manager.setPerson(null);
        manager.setCurrentPlayer(null);
        returnAccountMenu();
    }


}
