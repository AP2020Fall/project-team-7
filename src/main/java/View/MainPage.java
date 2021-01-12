package View;

import Controller.LoginManager;
import Controller.MainPageManager;
import Controller.Manager;
import Controller.RegisterManager;

public class MainPage extends Menu {
    public MainPage(Manager manager) {
        super(manager);
        System.out.println("1. show points\n" +
                        "2. favorite games\n" +
                        "3. platoBot's message\n" +
                        "4. view last played\n" +
                        "5. view Admin's suggestion" +
                        "6. choose suggested game\n" +
                        "7. add friend\n" +
                        "8. logout");

        while (true){
            String input = scanner.nextLine();
            if (input.matches("^1$")) {
                ((MainPageManager) manager).showPoints();
                break;
            } else if (input.matches("^2$")) {
                System.out.println("FG");
                break;
            } else if (input.matches("^3$")) {
                System.out.println("PM");
                break;
            }else if (input.matches("^4$")) {
                System.out.println("VL");
                break;
            } else if (input.matches("^5$")) {
                System.out.println("VA");
                break;
            } else if (input.matches("^6$")) {
                System.out.println("CS");
                break;
            } else if (input.matches("^7$")) {
                System.out.println("add");
                break;
            } else if (input.matches("^8$")) {
                System.out.println("logout");
                manager.setPerson(null);
                returnAccountMenu();
                break;
            } else {
                System.out.println("invalid command");
            }
        }
    }
}
