package Plato.Model;

import java.util.ArrayList;
import java.util.Date;

public class Admin extends Person {
    private ArrayList<String> adminSuggestion;

    public Admin(String firstName, String lastName, String username, String id,
                 String password, String email, String phoneNumber) {
        super(firstName, lastName, username, id, password, email, phoneNumber);
    }

    private void addEvent(Game gameName, Date start, Date finish, int score) {
        Event event = new Event(gameName, start, finish, score);
    }

    private void deleteEvent(Event event) {

    }

    public ArrayList<String> getAdminSuggestion() {
        return adminSuggestion;
    }

    public void setAdminSuggestion(ArrayList<String> adminSuggestion) {
        this.adminSuggestion = adminSuggestion;
    }

    @Override
    public String toString() {
        return "Admin{" + "\n" +
                "firstName='" + firstName + '\'' + "\n" +
                ", lastName='" + lastName + '\'' + "\n" +
                ", username='" + username + '\'' + "\n" +
                ", Id='" + Id + '\'' + "\n" +
                ", Email='" + Email + '\'' + "\n" +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
