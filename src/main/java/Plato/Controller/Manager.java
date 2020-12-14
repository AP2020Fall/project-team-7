package Plato.Controller;
import Plato.Model.Event;
import Plato.Model.Game;
import Plato.Model.Player;
import com.google.gson.Gson;
//import org.json.simple.JSONObject;
import java.util.ArrayList;

public class Manager {
    private ArrayList<Player> allUsers;
    private ArrayList<Game> games;
    private ArrayList<Event> events;
    Gson gson = new Gson();



    public ArrayList<Player> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(ArrayList<Player> allUsers) {
        this.allUsers = allUsers;
    }

    public void addPlayer(Player player){
        String detail;
        allUsers.add(player);
        setAllUsers(allUsers);
        detail = gson.toJson(player);
        //file output stream
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
