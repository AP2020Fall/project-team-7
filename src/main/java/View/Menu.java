package View;

import Controller.*;

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

    protected void returnGameMenu() {
        new GameMenuManager();
    }

    protected void logout() {
        System.out.println("logout");
        manager.setPerson(null);
        manager.setCurrentPlayer(null);
        returnAccountMenu();
    }



}
