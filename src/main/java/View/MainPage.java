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
            showPoints();

            //didn't check
        } else if (input.matches("^3$")) {
            showFavoriteGame();

        } else if (input.matches("^4$")) {
            showBotMessage();

        } else if (input.matches("^5$")) {
            viewLastPlayed();

        } else if (input.matches("^6$")) {
            System.out.println("VA");
            showMainPage();

        } else if (input.matches("^7$")) {
            showGames();

        } else if (input.matches("^8$")) {
            System.out.println("add");
            showMainPage();

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
            System.out.println(Game.getGames().get(Integer.parseInt(input)));
            System.out.println("1. play\n2. add this game to favorites");
            String choose = scanner.nextLine();
            if (choose.matches("^1$")) {
                System.out.println("playing " + Game.getGames().get(Integer.parseInt(input)));
                ((MainPageManager) manager).setLastPlayed(Game.getGames().get(Integer.parseInt(input)));
                //felan back
                showGames();
            } else if (choose.matches("^2$")) {
                ((MainPageManager) manager).addFavoriteGame(Game.getGames().get(Integer.parseInt(input)));
                System.out.println("add " + Game.getGames().get(Integer.parseInt(input)) + " to your favorite game");
            }
        } else if (Integer.parseInt(input) == Game.getGames().size() + 1) {
            showMainPage();
        } else if (Integer.parseInt(input) == Game.getGames().size() + 2) {
            goProfile();
        } else {
            System.err.println("invalid command!");
            showGames();
        }
    }

    private void showPoints(){
        ((MainPageManager) manager).showPoints();
        System.out.println("enter 'back' to return");
        while (!scanner.nextLine().equalsIgnoreCase("back")){
            System.err.println("invalid command. enter back to return!");
        }
        showMainPage();
    }

    private void showFavoriteGame(){
        System.out.println("your favorite game:\n" + ((MainPageManager) manager).showFavoriteGame());
        System.out.println("enter 'back' to return");
        while (!scanner.nextLine().equalsIgnoreCase("back")){
            System.err.println("invalid command. enter back to return!");
        }
        showMainPage();
    }

    private void showBotMessage(){
        System.out.println("bot message: " + ((MainPageManager) manager).showBotMessage());
        System.out.println("enter 'back' to return");
        while (!scanner.nextLine().equalsIgnoreCase("back")){
            System.err.println("invalid command. enter back to return!");
        }
        showMainPage();
    }

    private void viewLastPlayed(){
        System.out.println("last played:");
        ((MainPageManager) manager).viewLastPlayed();
        System.out.println("enter 'back' to return");
        while (!scanner.nextLine().equalsIgnoreCase("back")){
            System.err.println("invalid command. enter back to return!");
        }
        showMainPage();
    }

}
