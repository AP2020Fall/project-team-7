package Controller;

import Model.Player;
import View.LoginMenu;


public class LoginManager extends Manager{
    public LoginManager() {
        menu = new LoginMenu(this);
    }

    public boolean loginUser(String username, String password){
        for (Player player : getPlayers()) {
            if (currentPerson.getUsername().equals(username) && currentPerson.getPassword().equals(password)){
                setPerson(currentPerson);
                return true;
            }
        }
        return false;
    }
}