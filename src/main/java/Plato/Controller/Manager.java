package Plato.Controller;
import Plato.Model.Player;
import java.util.ArrayList;

public class Manager {
    Player player = null;
    private ArrayList<Player> allUsers;


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
}
