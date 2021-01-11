package Plato.Controller;

import Plato.Model.Admin;
import Plato.Model.Event;
import Plato.Model.Game;
import Plato.Model.Player;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Manager {
    private ArrayList<Player> allUsers;
    private HashMap<String, String> userLoginInfo;
    private ArrayList<Game> games;
    private ArrayList<Event> events;
    private Player currentPlayer;
    private UserControlPanel userControlPanel;
    private AdminControlPanel adminControlPanel;
    private EventControlPanel eventControlPanel;
    private PlatoBotController platoBotController;
    private GameControlPanel gameControlPanel;



    public Manager() {
        allUsers = new ArrayList<>();
        userLoginInfo = new HashMap<>();
        games = new ArrayList<>();
        events = new ArrayList<>();
        userControlPanel = new UserControlPanel();
        adminControlPanel = new AdminControlPanel();
        eventControlPanel = new EventControlPanel();
        platoBotController = new PlatoBotController();
        gameControlPanel = new GameControlPanel();
    }

    public ArrayList<Player> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(ArrayList<Player> allUsers) {
        this.allUsers = allUsers;
    }
//username, id, password, Email, phoneNum
    public void registerUser(String firstName, String lastName, String username, String Id, String password, String Email, String phoneNum) {
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

//        allUsers.add(player);
//        setAllUsers(allUsers);
//        currentPlayer = player;
        userControlPanel.registerUser(new Player(firstName, lastName, username, Id, password, Email, phoneNum));
        adminControlPanel.addUser(firstName, lastName, username, Id, password, Email, phoneNum);
    }

    public void registerAdmin(String firstName, String lastName, String username, String Id, String password, String Email, String phoneNum) {
        adminControlPanel.registerAdmin(new Admin(firstName, lastName, username, Id, password, Email, phoneNum));
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
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


    public void registerUser(Player player) {

    }

    public void addEvent (String gameName, Date  startDate, Date finishDate, int score){
        for (Game game : games) {
            if (game.getGameName().equals(gameName)){
                adminControlPanel.addEvent(game, startDate, finishDate, score);
            }
        }
    }
}
