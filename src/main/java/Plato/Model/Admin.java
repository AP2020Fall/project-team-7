package Plato.Model;

import java.util.Date;

public class Admin extends Person {

    public Admin(String firstName, String lastName, String username, String id,
                 String password, String email, String phoneNumber) {
        super(firstName, lastName, username, id, password, email, phoneNumber);
    }

    private void addEvent(Game gameName, Date start, Date finish, int score){
        Event event = new Event(gameName, start, finish, score);
    }

    private void deleteEvent(Event event){

    }


}
