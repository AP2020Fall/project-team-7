package Plato.Controller;

import Plato.Model.Event;
import Plato.Model.Game;
import Plato.Model.Player;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private ArrayList<Player> allUsers;
    private HashMap<String, String> userLoginInfo;
    private ArrayList<Game> games;
    private ArrayList<Event> events;


    public Manager() {
        allUsers = new ArrayList<>();
        userLoginInfo = new HashMap<>();
        games = new ArrayList<>();
        events = new ArrayList<>();
    }

    public ArrayList<Player> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(ArrayList<Player> allUsers) {
        this.allUsers = allUsers;
    }

    public void registerUser(Player player) {
//        try {
//            //complete
//            Gson gson = new Gson();
//            Writer writer = Files.newBufferedWriter(Paths.get("user.json"));
//            gson.toJson(player, writer);
//            writer.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        allUsers.add(player);
        setAllUsers(allUsers);
        System.out.println("register successfully!");
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

    public HashMap<String, String> getUser() {
        return userLoginInfo;
    }

    public void setUser(HashMap<String, String> user) {
        this.userLoginInfo = user;
    }


}
