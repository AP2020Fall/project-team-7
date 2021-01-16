package Controller;

import Model.Person;
import View.LoginMenu;


public class LoginManager extends Manager{
    public LoginManager() {
        menu = new LoginMenu(this);
    }

    public boolean loginUser(String username, String password){
        for (Person person : Person.getPeople()) {
            if (person.getUsername().equals(username) && person.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}