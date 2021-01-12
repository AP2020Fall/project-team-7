package Controller;

import View.MainPage;

public class MainPageManager extends Manager{
    public MainPageManager() {
        menu = new MainPage(this);
    }
}

