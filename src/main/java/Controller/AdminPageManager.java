package Controller;

import Model.Event;
import View.AdminPage;

import java.util.Date;

public class AdminPageManager extends Manager {
    public AdminPageManager() {
        menu = new AdminPage(this);
    }

    public void addEvent(String gameName, Date startDate, Date finishDate, int score) {
        Event event = new Event(gameName, startDate, finishDate, score);
        event.setEventId(event.getEventId() + 1);
    }

}
