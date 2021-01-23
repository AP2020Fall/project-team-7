package Plato.Controller;

import Plato.Model.Admin;
import Plato.Model.Person;
import Plato.Model.Player;
import Plato.View.Menu;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Manager {
    protected static Player currentPlayer = null;
    protected Person currentPerson = null;
    protected Admin admin = null;
    protected Menu menu;
    protected static ArrayList<Player> players = new ArrayList<>();

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player current) {
        currentPlayer = current;
    }

    @Test
    public void testCurrentPlayer() {
        Player currentPlayer = new Player("abc", "12345", "salam@yahoo.com", "a", "bc", "09131238787");
        setCurrentPlayer(currentPlayer);
        Assert.assertEquals(getCurrentPlayer(), currentPlayer);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    @Test
    public void getPlayerTest() {
        ArrayList<Player> excepted = new ArrayList<>();
        Player player = new Player("a", "a", "ab@AB.com", "ab", "ba", "09123211514");
        excepted.add(player);
        Assert.assertNotEquals(getPlayers(), excepted);
        players.add(player);
        Assert.assertEquals(excepted, getPlayers());
    }

    public Person getPerson() {
        return currentPerson;
    }

    public void setPerson(Person person) {
        this.currentPerson = person;
    }

    @Test
    public void getPersonTest() {
        Person person = new Person("a", "a", "ab@AB.com", "ab", "ba", "09123211514");
        setPerson(person);
        Person actual = getPerson();
        Assert.assertEquals(actual, person);
        person = new Person("abi", "a", "ab@AB.com", "ab", "ba", "09123211514");

        Assert.assertNotEquals(person, getPerson());
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

    @Test
    public void isThisCurrentPlayerTest() {
        Person person = new Person("salam", "simsim", "ab@AB.com", "ab", "ba", "09123211514");
        setPerson(person);
        String username = "salam";
        Assert.assertEquals(person.getUsername(), username);
        username = "mah";
        Assert.assertNotEquals(person.getUsername(), username);
    }

    public boolean checkEmail(String email) {
        return email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
    }

    @Test
    public void checkEmailTest() {
        boolean actual = checkEmail("sara@gmail.com");
        Assert.assertEquals(true, actual);
        actual = checkEmail("dkhd");
        Assert.assertEquals(actual, false);

    }

    public boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("09\\d{9}");
    }

    @Test
    public void checkPhoneNumTest() {
        boolean actual = checkPhoneNumber("09123214565");
        Assert.assertTrue(actual);
        actual = checkPhoneNumber("030874");
        Assert.assertFalse(actual);
        Assert.assertFalse(checkPhoneNumber("ashljdh"));
    }

    public boolean checkDate(String date) {
        return date.matches("^dddd-dd-dd$");
    }

    @Test
    public void dateTest() {
        Assert.assertFalse(checkDate("2020-10-11"));
        Assert.assertFalse(checkPassword("10/10/01"));
    }

    public boolean checkPassword(String password) {
        if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$")) {
            return true;
        }
        return false;
    }

    @Test
    public void passwordTest() {
        Assert.assertTrue(checkPassword("AB123Salam"));
        Assert.assertFalse(checkPassword("1234"));
        Assert.assertFalse(checkDate("ejhe"));
    }

    public boolean isThisPasswordCorrect(String password) {
        return getCurrentPlayer().getPassword().equals(password);
    }

    @Test
    public void correctPassTest(){
        String pass = "ABS1234abs";
        Player player = new Player("a", "ABS1234abs", "ab@AB.com", "ab", "ba", "09123211514");
        setCurrentPlayer(player);
        Assert.assertTrue(isThisPasswordCorrect(pass));
        Assert.assertFalse(isThisPasswordCorrect("chemidoonam"));
    }

}
