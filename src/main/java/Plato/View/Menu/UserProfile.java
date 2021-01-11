package Plato.View.Menu;

import Plato.Controller.Manager;

import java.util.HashMap;

public class UserProfile extends Menu {
    private String command;

    public UserProfile(String name, Menu parentMenu) {
        super("Profile", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, viewPersonalInfo());
        submenus.put(2, changePassword());
        submenus.put(3, editField());
        submenus.put(4, viewPlatoStatistics());
        submenus.put(5, gameHistory());
        submenus.put(6, gameStatistics());
        submenus.put(7, showPoints());
        submenus.put(8, showFavoriteGame());
        submenus.put(9, showPlatoBotMessage());
        submenus.put(10, viewLastPlayed());
        submenus.put(11, viewAdminSuggestion());
        submenus.put(12, addFriend());
        submenus.put(13, logout());
        this.setSubmenus(submenus);
    }

//    private void viewPersonalInfo(){
//        System.out.println(manager.getCurrentPlayer().toString());
//    }


    private Menu viewPersonalInfo() {
        return new Menu("view personal info", this) {

        };
    }

    private Menu changePassword() {
        return new Menu("change password", this) {

        };
    }

    private Menu editField() {
        return new Menu("edit field", this) {

        };
    }

    private Menu viewPlatoStatistics() {
        return new Menu("view plato statistics", this) {

        };
    }

    private Menu gameHistory() {
        return new Menu("game history", this) {

        };
    }


    private Menu gameStatistics() {
        return new Menu("game statistics", this) {

        };
    }


    private Menu showPoints() {
        return new Menu("show points", this) {

        };
    }

    private Menu showFavoriteGame() {
        return new Menu("show favorite game", this) {

        };
    }

    private Menu showPlatoBotMessage() {
        return new Menu("show platoBot message", this) {

        };
    }

    private Menu viewLastPlayed() {
        return new Menu("view last played", this) {

        };
    }

    private Menu viewAdminSuggestion() {
        return new Menu("view admin suggestion", this) {

        };
    }

    private Menu addFriend() {
        //get the username of player and request to him
        return new Menu("add friend", this) {

        };
    }

    private Menu logout() {
        return new Menu("logout", parentMenu) {
            @Override
            public void show() {
                parentMenu.show();
            }

            @Override
            public void execute() {
                parentMenu.execute();
            }
        };
    }

}
