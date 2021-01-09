package Plato.View.Menu;

import Plato.Model.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class UserProfile extends Menu{
    private LoginMenu loginMenu;

    public UserProfile(String name, Menu parentMenu) {
        super("Profile", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, viewPersonalInfo());
        submenus.put(2, changePassword());
        submenus.put(3, editField());
        this.setSubmenus(submenus);
        loginMenu = new LoginMenu(null);
    }

    private Menu viewPersonalInfo(){
        return new Menu("viewPersonalInfo", this) {

        };
    }

    private Menu changePassword(){
        return new Menu("changePassword", this) {

        };
    }

    private Menu editField(){
        return new Menu("editField", this) {

        };
    }

    private Menu viewPlatoStatistics(){
        return new Menu("ViewPlatoStatistics", this) {

        };
    }

    private Menu gameHistory(){
        return new Menu("gameHistory", this) {

        };
    }


    private Menu gameStatistics(){
        return new Menu("gameStatistics", this){

        };
    }

    private Menu logout(){
        return new Menu("logout", loginMenu){

        };
    }
    //...........................
    private Menu showPoints(){
        return new Menu("showPoints", this) {

        };
    }

    private Menu showFavoriteGame(){
        return new Menu("showFavoriteGame", this) {

        };
    }

    private Menu showPlatoBotMessage(){
        return new Menu("show platoBot message", this) {

        };
    }

    public static void viewLastPlayed(){

    }

    public static void viewAdminSuggestion(){

    }

    public static void addFriend(Player player){
        //get the username of player and request to him
    }


}
