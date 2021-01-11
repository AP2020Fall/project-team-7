package Controller;

import View.LoginMenu;
import View.RegisterMenu;

public class LoginManager extends Manager{
    public LoginManager() {
        menu = new LoginMenu(this);

    }
}