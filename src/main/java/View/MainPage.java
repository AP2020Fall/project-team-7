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
                        "wins: " + ((MainPageManager) manager).getWins() + "\n" +
                        "your requests result:\n" +
                        ((MainPageManager) manager).showRequestResult() + "\n" +
                        "1. profile\n" +
                        "2. show points\n" +
                        "3. favorite games\n" +
                        "4. platoBot's message\n" +
                        "5. view last played\n" +
                        "6. view Admin's suggestion\n" +
                        "7. games\n" +
                        "8 .show friends\n" +
                        "9 .show requests\n" +
                        "10. add friend\n" +
                        "11. profile\n" +
                        "12. logout"));

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
            showFriends();

        } else if (input.matches("^9$")) {
            showRequests();

        } else if (input.matches("^10$")) {
            requestToFriend();

        } else if (input.matches("^11$")) {
            goProfile();

        } else if (input.matches("^12$")) {
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
                System.out.println("enter back to return.");
                if (input.equalsIgnoreCase("back"))
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

    private void showPoints() {
        ((MainPageManager) manager).showPoints();
        System.out.println("enter 'back' to return");
        while (!scanner.nextLine().equalsIgnoreCase("back")) {
            System.err.println("invalid command. enter back to return!");
        }
        showMainPage();
    }

    private void showFavoriteGame() {
        System.out.println("your favorite game:\n" + ((MainPageManager) manager).showFavoriteGame());
        System.out.println("enter 'back' to return");
        while (!scanner.nextLine().equalsIgnoreCase("back")) {
            System.err.println("invalid command. enter back to return!");
        }
        showMainPage();
    }

    private void showBotMessage() {
        System.out.println("bot message: " + ((MainPageManager) manager).showBotMessage());
        System.out.println("enter 'back' to return");
        while (!scanner.nextLine().equalsIgnoreCase("back")) {
            System.err.println("invalid command. enter back to return!");
        }
        showMainPage();
    }

    private void viewLastPlayed() {
        System.out.println("last played:");
        ((MainPageManager) manager).viewLastPlayed();
        System.out.println("enter 'back' to return");
        while (!scanner.nextLine().equalsIgnoreCase("back")) {
            System.err.println("invalid command. enter back to return!");
        }
        showMainPage();
    }

    private void requestToFriend() {
        System.out.println("enter username\nor enter 'back' to return");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("back")) {
            showMainPage();
        } else {
            if (manager.isThisUsernameExist(input) && !manager.getPerson().getUsername().equals(input)) {
                ((MainPageManager) manager).sendRequest(input);
            } else {
                if (manager.getPerson().getUsername().equals(input)) {
                    System.err.println("you cannot add yourself to your friend!");
                    requestToFriend();
                }
                System.err.println("the user not found!");
                requestToFriend();
            }
        }
        while (!scanner.nextLine().equalsIgnoreCase("back")) {
            System.err.println("invalid command. enter back to return!");
        }
        showMainPage();
    }

    private void showFriends() {
        ((MainPageManager) manager).showFriendList();
        System.out.println("" +
                "1. profile [username]\n" +
                "2. remove [username]\n" +
                "3. search [username]\n" +
                "4. back");
        String input = scanner.nextLine();
        if (input.startsWith("profile") || input.matches("^1$")){
            System.out.println("enter username:");
            input = scanner.nextLine();
            showFriendProfile(input);
        }
        showMainPage();
    }

    private void showFriendProfile(String username){
        ((MainPageManager)manager).showProfileToOtherUsers(username);
        String input = scanner.nextLine();
        System.out.println("1. report!");
        System.out.println("2. back");
        if (input.matches("^1$")){
            ((MainPageManager)manager).reportUser(username);
            System.out.println("thanks to report!");
        } else if (input.matches("^2$")){
            showFriends();
        } else {
            System.err.println("invalid input!");
            showFriendProfile(username);
        }
    }

    private void showRequests() {
        System.out.println("your requests");
        ((MainPageManager) manager).showRequests();
        System.out.println("" +
                "1. accept [username]\n" +
                "2. reject [username]");
        System.out.println("enter 'back' to return");
        String input = scanner.nextLine();
        if (input.startsWith("accept")) {
            if (((MainPageManager) manager).isThisUserRequest(input.split("\\s+")[1])) {
                ((MainPageManager) manager).addFriend(input.split("\\s+")[1]);
                ((MainPageManager) manager).acceptAndReject(input.split("\\s+")[1], true);
                System.out.println(input.split("\\s+")[1] + "added to your friends.");
            } else {
                System.out.println("there is no player with this id requests to you :|");
            }
            showRequests();
        } else if (input.startsWith("reject")) {
            if (((MainPageManager) manager).isThisUserRequest(input.split("\\s+")[1])) {
                ((MainPageManager) manager).acceptAndReject(input.split("\\s+")[1], false);
                System.out.println("Oh! you put away " + input.split("\\s+")[1]);
            } else {
                System.out.println("there is no player with this id requests to you :|");
            }
            showRequests();
        } else if (input.equalsIgnoreCase("back")) {
            showMainPage();
        } else {
            System.err.println("invalid input!");
            showRequests();
        }
    }
}
