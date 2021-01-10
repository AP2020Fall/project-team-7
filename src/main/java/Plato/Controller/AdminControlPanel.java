package Plato.Controller;

import Plato.Model.*;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;

public class AdminControlPanel {
    Manager manager = new Manager();
    Player player = null;

    public void addEvent(Game game, Date startDate, Date finishDate, int score){

    }

    public void registerAdmin(Admin admin){

    }

    public void viewEventDetail(){

    }

    public void editEvent(Event eventId, Object currentObj, Object newObj){

    }

    public void removeEvent(Event eventId){

    }

    public void addSuggestion (Player username, Game game){

    }

    public void viewDetailAllSuggestion(){

    }

    public void removeSuggestion(String suggestionId){

    }

    public ArrayList<Player> viewUsers(){
        return manager.getAllUsers();
    }

    private void addUsername(Player player){
        manager.registerUser(player);
    }

    public void viewUserProfile(String username){

    }

    public void viewAdminInfo(Admin admin){
        System.out.println(admin.toString());
    }
}
