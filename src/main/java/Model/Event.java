package Model;

import java.util.ArrayList;
import java.util.Date;

public class Event {
    private String  gameName;
    private Date startDate;
    private Date finishDate;
    private int eventScore;
    private int eventId = 1000;
    private ArrayList<Event> events;

    public Event(String  gameName, Date startDate, Date finishDate, int eventScore) {
        this.gameName = gameName;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.eventScore = eventScore;
        events = new ArrayList<>();
        events.add(this);
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
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

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}
