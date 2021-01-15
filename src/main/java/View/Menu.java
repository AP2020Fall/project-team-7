package View;

import Controller.AccountManager;
import Controller.MainPageManager;
import Controller.Manager;
import Controller.ProfileManager;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    protected static Scanner scanner = new Scanner(System.in);
    protected Manager manager;

    public Menu(Manager manager) {
        this.manager = manager;
    }

    protected Matcher getMatcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }

    protected void returnAccountMenu(){
        new AccountManager();
    }

    protected void goProfile(){
        new ProfileManager();
    }

    protected void returnMainPage(){
        new MainPageManager();
    }

    protected void logout(){
        System.out.println("logout");
        manager.setPerson(null);
        returnAccountMenu();
    }


}
