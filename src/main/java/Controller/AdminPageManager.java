package Controller;

import Model.Event;
import Model.Game;
import View.AdminPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.beans.Transient;
import java.util.Date;

public class AdminPageManager extends Manager {
    public static String comment = "";
    Game dotsAndBoxes = new Game("Dots And Boxes", 1);
    Game reversi= new Game("Reversi", 2);

    public AdminPageManager() {
        menu = new AdminPage(this);
    }

    public static String getComment() {
        return comment;
    }


    public void addEvent(String gameName, Date startDate, Date finishDate, int score) {
        Event event = new Event(gameName, startDate, finishDate, score);
        event.setEventId(event.getEventId() + 1);
    }

    public void editDate(int eventId, Date finish) {
        boolean isThisEventExist = false;
        for (Event event : Event.getEvents()) {
            if (event.getEventId() == eventId) {
                isThisEventExist = true;
                event.setFinishDate(finish);
                System.out.println("event finish date changed to " + finish);
                break;
            }
        }
        if (!isThisEventExist) {
            System.err.println("Event not found!");
        }
    }

    public void changeGameName(String name1, String name2) {
        for (Game game : Game.getGames()) {
            if (game.getName().equalsIgnoreCase(name1)) {
                game.setName(name2);
                break;
            }
        }
    }

    public void deleteGame(String gameName) {
        for (Game game : Game.getGames()) {
            if (game.getName().equalsIgnoreCase(gameName)) {
                Game.games.remove(game);
                break;
            }
        }
    }

    public boolean isThisGameExist(String gameName) {
        boolean find = false;
        for (Game game : Game.getGames()) {
            if (game.getName().equalsIgnoreCase(gameName)) {
                find = true;
                break;
            }
        }
        return find;
    }


}
