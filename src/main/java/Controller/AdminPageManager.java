package Controller;

import View.AdminPage;
import View.MainPage;

public class AdminPageManager extends Manager{
    public AdminPageManager() {
        menu = new AdminPage(this);
    }
}
