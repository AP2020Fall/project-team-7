package Controller;

import Model.Person;
import Model.Player;
import View.Menu;

import java.util.ArrayList;

public class Manager {
    protected Person person = null;
    protected Menu menu;
    protected ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(Player player){
        players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public boolean checkEmail(String email) {
        if (email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
            return true;
        }
        return false;
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("09\\d{9}")) {
            return true;
        }
        return false;
    }

    public boolean checkPassword(String password) {
        if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$")) {
            return true;
        }
        return false;
    }

}
