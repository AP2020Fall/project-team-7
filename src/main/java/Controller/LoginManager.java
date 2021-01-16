package Controller;

import Model.Admin;
import Model.Person;
import Model.Player;
import View.LoginMenu;


public class LoginManager extends Manager {
    public LoginManager() {
        menu = new LoginMenu(this);
    }

    public boolean canLoginUser(String username, String password) {
        for (Person person : Person.getPeople()) {
            if (person.getUsername().equals(username) && person.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void loginUser(String username) {
        Person person = null;
        for (Person p : Person.getPeople()) {
            if (p.getUsername().equals(username)) {
                setPerson(p);
                person = p;
                break;
            }
        }
        if (Person.getPeople().get(0).equals(person)) {
            setAdmin((Admin) person);
            new AdminPageManager();
        } else {
            setCurrentPlayer((Player) person);
            new MainPageManager();
        }
    }

}