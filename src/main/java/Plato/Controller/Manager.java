package Plato.Controller;
import Plato.Model.Event;
import Plato.Model.Game;
import Plato.Model.Player;
import org.ietf.jgss.GSSManager;

import java.util.ArrayList;

public class Manager {
    private ArrayList<Player> allUsers;
    private ArrayList<Game> games;
    private ArrayList<Event> events;


    public ArrayList<Player> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(ArrayList<Player> allUsers) {
        this.allUsers = allUsers;
    }

    public void addPlayer(Player player){
        allUsers.add(player);
        setAllUsers(allUsers);
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}
