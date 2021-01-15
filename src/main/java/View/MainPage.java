package View;

import Controller.AdminPageManager;
import Controller.MainPageManager;
import Controller.Manager;
import Controller.ProfileManager;
import Model.Game;

public class MainPage extends Menu {
    public MainPage(Manager manager) {
        super(manager);
        showMainPage();
    }

    private void showMainPage() {
        if (AdminPageManager.getComment().length() != 0) {
            System.out.print("Admin comment: ");
        }
        System.out.println("" +
                (AdminPageManager.getComment() + "\n" +
                        "Main page:\n" +
                        "1. profile\n" +
                        "2. show points\n" +
                        "3. favorite games\n" +
                        "4. platoBot's message\n" +
                        "5. view last played\n" +
                        "6. view Admin's suggestion\n" +
                        "7. games\n" +
                        "8. add friend\n" +
                        "9. profile\n" +
                        "10. logout"));


        String input = scanner.nextLine();
        if (input.matches("^1$")) {
            manager = new ProfileManager();
        } else if (input.matches("^2$")) {
            //nullPointerException
            ((MainPageManager) manager).showPoints();

            //didn't check
        } else if (input.matches("^3$")) {
            System.out.println("your favorite game:\n" + ((MainPageManager) manager).showFavoriteGame());

        } else if (input.matches("^4$")) {
            System.out.println("bot message: " + ((MainPageManager) manager).showBotMessage());

        } else if (input.matches("^5$")) {
            System.out.println("last played: " + ((MainPageManager) manager).viewLastPlayed().toString());

        } else if (input.matches("^6$")) {
            System.out.println("VA");

        } else if (input.matches("^7$")) {
            showGames();

        } else if (input.matches("^8$")) {
            System.out.println("add");

        } else if (input.matches("^9$")) {
            goProfile();

        } else if (input.matches("^10$")) {
            logout();
        } else {
            System.err.println("invalid command");
            showMainPage();
        }
    }

    private void showGames() {
        System.out.println("games\n:");
        for (int i = 0; i < Game.getGames().size(); i++) {
            System.out.println(i + 1 + ". " + Game.getGames().get(i));
        }
        System.out.println(
                (Game.getGames().size() + 1) + ". back\n" +
                        (Game.getGames().size() + 2) + ". profile");
        String input = scanner.nextLine();
        if (Integer.parseInt(input) <= Game.getGames().size()) {
            System.out.println("play " + Game.getGames().get(Integer.parseInt(input)));
            ((MainPageManager)manager).setLastPlayed(Game.getGames().get(Integer.parseInt(input)));
        } else if (Integer.parseInt(input) == Game.getGames().size() + 1) {
            showMainPage();
        } else if (Integer.parseInt(input) == Game.getGames().size() + 2) {
            goProfile();
        } else {
            System.err.println("invalid command!");
            showGames();
        }
    }

}
