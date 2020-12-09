package Plato.Model;

import java.util.Date;

public class Event {
    private Game gameName;
    private Date startDate;
    private Date finishDate;
    private int eventScore;
    private String eventId;

    public Event(Game gameName, Date startDate, Date finishDate, int eventScore) {
        this.gameName = gameName;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.eventScore = eventScore;
    }

    public void addEvent(Event event, Date startDate, Date finishDate){

    }
}
