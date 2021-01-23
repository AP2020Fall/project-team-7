package Plato.Controller;

import Plato.View.AccountMenu;

public class AccountManager extends Manager {

    public AccountManager() {
        menu = new AccountMenu(this);
    }
}
