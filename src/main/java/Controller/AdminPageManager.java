package Controller;

import Model.Event;
import Model.Game;
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

    public void editDate(int eventId, Date finish){
        boolean isThisEventExist = false;
        for (Event event : Event.getEvents()) {
            if (event.getEventId() == eventId){
                isThisEventExist = true;
                event.setFinishDate(finish);
                System.out.println("event finish date changed to " + finish);
                 break;
            }
        }
        if (!isThisEventExist){
            System.err.println("Event not found!");
        }
    }

    public void changeGameName(String name1, String name2){
        for (Game game : Game.getGames()) {
            if (game.getName().equalsIgnoreCase(name1)){
                game.setName(name2);
                break;
            }
        }
    }

    public boolean isThisGameExist(String gameName){
        boolean find = false;
        for (Game game : Game.getGames()) {
            if (game.getName().equalsIgnoreCase(gameName)){
                find = true;
                break;
            }
        }
        return find;
    }


}
