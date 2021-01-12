package Controller;

import Model.Player;
import View.LoginMenu;


public class LoginManager extends Manager{
    public LoginManager() {
        menu = new LoginMenu(this);
    }

    public boolean loginUser(String username, String password){
        for (Player player : getPlayers()) {
            if (person.getUsername().equals(username) && person.getPassword().equals(password)){
                setPerson(person);
                return true;
            }
        }
        return false;
    }
}