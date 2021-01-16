package Controller;

import Model.Admin;
import Model.Person;
import Model.Player;
import View.Menu;
import org.testng.Assert;
import org.testng.annotations.Test;

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

    @Test
    public void testCurrentPlayer(){
        Player currentPlayer = new Player("abc", "12345", "salam@yahoo.com", "a", "bc", "09131238787");
        setCurrentPlayer(currentPlayer);
        Assert.assertEquals(getCurrentPlayer(), currentPlayer);
    }

    public void setCurrentPlayer(Player current) {
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

    @Test
    public void checkEmailTest(){
        boolean actual = checkEmail("sara@gmail.com");
        Assert.assertEquals(true, actual);
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("09\\d{9}");
    }

    @Test
    public void checkPhoneNumTest(){
        boolean actual = checkPhoneNumber("09123214565");
        Assert.assertEquals(true, actual);
        actual = checkPhoneNumber("030874");
        Assert.assertEquals(false, actual);
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
