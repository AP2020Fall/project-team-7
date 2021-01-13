package View;

import Controller.MainPageManager;
import Controller.Manager;
import Controller.ProfileManager;

public class AdminPage extends Menu {
    public AdminPage(Manager manager) {
        super(manager);
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
            } else if (input.matches("^2$")) {
                //delete game

                break;
            } else if (input.matches("^3$")) {
                //disable game for update

                break;
            } else if (input.matches("^4$")) {
                //put comment in home

                break;
            } else if (input.matches("^5$")) {
                //add event

                break;
            } else if (input.matches("^6$")) {
                //change event's finish date
                break;
            } else if (input.matches("^7$")) {
                System.out.println("all users:\n" + manager.getPlayers());
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
}
