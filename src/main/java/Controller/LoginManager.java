package Controller;

import Model.Player;
import View.LoginMenu;


public class LoginManager extends Manager{
    public LoginManager() {
        menu = new LoginMenu(this);
    }

    public boolean loginUser(String username, String password){
        for (Player player : getPlayers()) {
            if (player.getUsername().equals(username) && player.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}