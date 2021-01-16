package Controller;

import Model.Admin;
import Model.Person;
import Model.Player;
import View.Menu;

import java.util.ArrayList;

public class Manager {
    protected static Player currentPlayer = null;
    protected Person currentPerson = null;
    protected Admin admin = null;
    protected Menu menu;
    protected ArrayList<Player> players = new ArrayList<>();

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player current) {
        currentPlayer = current;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Person getPerson() {
        return currentPerson;
    }

    public void setPerson(Person person) {
        this.currentPerson = person;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public boolean isThisUsernameExist(String username) {
        for (Person person : Person.getPeople()) {
            if (person.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean isThisCurrentPlayer(String username) {
        return getCurrentPlayer().getUsername().equals(username);
    }

    public boolean checkEmail(String email) {
        return email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("09\\d{9}");
    }

    public boolean checkDate(String date) {
        return date.matches("^dddd-dd-dd$");
    }

    public boolean checkPassword(String password) {
        if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$")) {
            return true;
        }
        return false;
    }

    public boolean isThisPasswordCorrect(String password) {
        return getCurrentPlayer().getPassword().equals(password);
    }
}
