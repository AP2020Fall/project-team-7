package Plato.Model;

import java.util.Date;

public class Admin extends Person {

    public Admin(String firstName, String lastName, String username, String id,
                 String password, String email, String phoneNumber) {
        super(firstName, lastName, username, id, password, email, phoneNumber);
    }

    private void addEvent(Event event, Date start, Date finish){

    }

    private void deleteEvent(Event event){

    }


}
