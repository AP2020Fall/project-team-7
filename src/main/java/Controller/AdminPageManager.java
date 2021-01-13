package Controller;

import Model.Event;
import Model.Player;
import View.AdminPage;
import View.MainPage;

import java.util.Date;

public class AdminPageManager extends Manager{
    public AdminPageManager() {
        menu = new AdminPage(this);
    }

    public void addEvent(String gameName, Date startDate, Date finishDate, int score){
        new Event(gameName, startDate, finishDate, score);
    }

}
