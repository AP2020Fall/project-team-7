package Model;

import java.util.ArrayList;
import java.util.Date;

public class Admin extends Person {
    private ArrayList<String> adminSuggestion;

    public Admin(String userName, String password, String email, String fName, String lName, String phoneNum) {
        super(userName, password, email, fName, lName, phoneNum);
        username = userName;
        Email = email;
        firstName = fName;
        lastName = lName;
        phoneNumber = phoneNum;
        setPassword(password);
    }

    private void addEvent(String gameName, Date start, Date finish, int score) {
        Event event = new Event(gameName, start, finish, score);
    }

    public ArrayList<String> getAdminSuggestion() {
        return adminSuggestion;
    }

    public void setAdminSuggestion(ArrayList<String> adminSuggestion) {
        this.adminSuggestion = adminSuggestion;
    }

    @Override
    public String toString() {
        return "Admin:" + "\n" +
                "firstName='" + firstName + '\'' + "\n" +
                "lastName='" + lastName + '\'' + "\n" +
                "username='" + username + '\'' + "\n" +
                "Email='" + Email + '\'' + "\n" +
                "phoneNumber='" + phoneNumber + '\'';
    }
}
