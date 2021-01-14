package View;

import Controller.AdminPageManager;
import Controller.Manager;
import Model.Game;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminPage extends Menu {
    public AdminPage(Manager manager) {
        super(manager);
        showAdminMenu();
    }

    private void showAdminMenu() {
        System.out.println("" +
                "Admin page:\n" +
                "1. change game's name\n" +
                "2. delete game\n" +
                "3. disable game for update\n" +
                "4. put comment in home\n" +
                "5. add event\n" +
                "6. change event's finish date\n" +
                "7. view all users\n" +
                "8. ban user\n" +
                "9. logout");
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("^1$")) {
                //change game's name
                changeGameName();
                break;
            } else if (input.matches("^2$")) {
                //delete game
                deleteGame();
                break;
            } else if (input.matches("^3$")) {
                //disable game for update
                showAdminMenu();
                break;
            } else if (input.matches("^4$")) {
                //put comment in home
                showAdminMenu();
                break;
            } else if (input.matches("^5$")) {
                addEvent();
                break;
            } else if (input.matches("^6$")) {
                editEventDate();
                break;
            } else if (input.matches("^7$")) {
                System.out.println("all users:\n" + manager.getPlayers());
                showAdminMenu();
                break;

            } else if (input.matches("^8$")) {
                //ban user
                break;

            } else if (input.matches("^9$")) {
                System.out.println("logout");
                manager.setPerson(null);
                returnAccountMenu();
                break;

            } else {
                System.err.println("invalid command");
            }
        }
    }

    private void addEvent() {
        System.out.println("enter game's name: ");
        String gameName = scanner.nextLine();
        System.out.println("date format: 'yyyy-MM-dd'");
        System.out.println("start:");
        String startDate = scanner.nextLine();
        System.out.println("finish:");
        String finishDate = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date finish = null;
        try {
            start = sdf.parse(startDate);
            finish = sdf.parse(finishDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (manager.checkDate(startDate) && manager.checkDate(finishDate)) {
            int score = scanner.nextInt();
            ((AdminPageManager) manager).addEvent(gameName, start, finish, score);
        } else {
            System.err.println("invalid date! pattern: yyyy-MM-dd");
        }
        showAdminMenu();
    }

    private void editEventDate() {
        System.out.println("date format: 'yyyy-MM-dd'");
        int eventId = scanner.nextInt();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String finishDate = scanner.nextLine();
        if (manager.checkDate(finishDate)) {
            Date finish = null;
            try {
                finish = sdf.parse(finishDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ((AdminPageManager) manager).editDate(eventId, finish);
        } else {
            System.err.println("invalid date! pattern: yyyy-MM-dd");
        }
        showAdminMenu();
    }


    private void changeGameName() {
        System.out.println("games:\n" + Game.getGames().toString());
        System.out.println("enter game's name:");
        String gameName = scanner.nextLine();
        if (((AdminPageManager) manager).isThisGameExist(gameName)) {
            System.out.println("enter new name:");
            String changedName = scanner.nextLine();
            ((AdminPageManager) manager).changeGameName(gameName, changedName);
            System.out.println("changed " + gameName + " name to " + changedName);
        } else {
            System.err.println("there is no game with name " + gameName);
        }
        showAdminMenu();
    }

    private void deleteGame() {
        System.out.println("games:\n" + Game.getGames().toString());
        System.out.println("enter game's name:");
        String gameName = scanner.nextLine();
        if (((AdminPageManager) manager).isThisGameExist(gameName)) {
            ((AdminPageManager) manager).deleteGame(gameName);
            System.out.println("" + gameName + " game deleted.");
        } else
            System.err.println("there is no game with name " + gameName);
        showAdminMenu();
    }
}
