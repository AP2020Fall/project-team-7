package Plato.Controller;

import Plato.Model.*;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;

public class AdminControlPanel {
    private ArrayList<String> allUsers;
    public void addEvent(Game game, Date startDate, Date finishDate, int score){

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

    public ArrayList<String> viewUsers(){
        return allUsers;
    }

    private void addUsername(Player player){
        allUsers.add(player.getUsername());
    }

    public void viewUserProfile(String username){

    }
}
