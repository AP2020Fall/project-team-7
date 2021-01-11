package Plato.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Event {
    private Game gameName;
    private Date startDate;
    private Date finishDate;
    private int eventScore;
    private String eventId;
    private ArrayList<Event> events;

    public Event(Game gameName, Date startDate, Date finishDate, int eventScore) {
        this.gameName = gameName;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.eventScore = eventScore;
        events = new ArrayList<>();
    }

    public Game getGameName() {
        return gameName;
    }

    public void setGameName(Game gameName) {
        this.gameName = gameName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public int getEventScore() {
        return eventScore;
    }

    public void setEventScore(int eventScore) {
        this.eventScore = eventScore;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}
