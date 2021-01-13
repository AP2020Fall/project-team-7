package View;

import Controller.MainPageManager;
import Controller.Manager;
import Controller.ProfileManager;

public class MainPage extends Menu {
    public MainPage(Manager manager) {
        super(manager);
        System.out.println("Main page:\n" +
                "1. profile\n" +
                "2. show points\n" +
                "3. favorite games\n" +
                "4. platoBot's message\n" +
                "5. view last played\n" +
                "6. view Admin's suggestion\n" +
                "7. choose suggested game\n" +
                "8. add friend\n" +
                "9. logout");

        while (true) {
            String input = scanner.nextLine();
            if (input.matches("^1$")) {
                manager = new ProfileManager();
            } else if (input.matches("^2$")) {
                //nullPointerException
                ((MainPageManager) manager).showPoints();
                break;
                //didn't check
            } else if (input.matches("^3$")) {
                System.out.println("your favorite game:\n" + ((MainPageManager) manager).showFavoriteGame());
                break;
            } else if (input.matches("^4$")) {
                System.out.println("PM");
                break;
            } else if (input.matches("^5$")) {
                System.out.println("VL");
                break;
            } else if (input.matches("^6$")) {
                System.out.println("VA");
                break;
            } else if (input.matches("^7$")) {
                System.out.println("CS");
                break;

            } else if (input.matches("^8$")) {
                System.out.println("add");
                break;

            } else if (input.matches("^9$")){
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
