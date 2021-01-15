package Controller;

import Model.Game;
import Model.Player;
import View.MainPage;

import java.util.ArrayList;

public class MainPageManager extends Manager {

    public MainPageManager() {
        menu = new MainPage(this);
    }

    public void showPoints() {
        System.out.println(getCurrentPlayer().getScore());
    }

    public ArrayList<Game> showFavoriteGame() {
        return getCurrentPlayer().getFavoriteGame();
    }

    public ArrayList<String> showBotMessage() {
        return getCurrentPlayer().getPlatoBotMessage();
    }

    public void viewLastPlayed() {
        for (int i = getCurrentPlayer().getLastPlayed().size() - 1; i >= 0; i--) {
            System.out.println(getCurrentPlayer().getLastPlayed().get(i).toString());
        }
    }

    public void setLastPlayed(Game game) {
        getCurrentPlayer().getLastPlayed().add(game);
    }

    public void addFavoriteGame(Game game) {
        getCurrentPlayer().getFavoriteGame().add(game);
    }

    public void addFriend(String username) {
        for (Player player : getCurrentPlayer().getFriendList()) {
            if (player.getUsername().equals(username)) {
                getCurrentPlayer().getFriendList().add(player);
                break;
            }
        }
    }

    public void sendRequest(String username) {
        for (Player player : getCurrentPlayer().getFriendList()) {
            if (player.getUsername().equals(username)) {
                player.getRequests().add(getCurrentPlayer().getUsername());
                break;
            }
        }
    }

    public boolean isThisUserRequest(String username) {
        for (Player player : getCurrentPlayer().getFriendList()) {
            if (player.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void showRequests() {
        for (int i = 0; i < getCurrentPlayer().getRequests().size(); i++) {
            System.out.println((i + 1) + ". " + getCurrentPlayer().getRequests().get(i) + " wants to be your friend!");
        }
    }

    public void showFriendList() {
        for (int i = 0; i < getCurrentPlayer().getFriendList().size(); i++) {
            System.out.println((i + 1) + ". " + getCurrentPlayer().getFriendList().get(i));
        }
    }

    public int getWins() {
        return currentPlayer.getWins();
    }

    public void acceptAndReject(String username, boolean accept) {
        for (Player player : getPlayers()) {
            if (player.getUsername().equals(username)) {
                if (accept) {
                    player.getAcceptAndReject().add(getCurrentPlayer().getUsername() + " accepted your request!");
                } else {
                    player.getAcceptAndReject().add(getCurrentPlayer().getUsername() + " put you away :(");
                }
                break;
            }
        }
    }

    public ArrayList<String> showRequestResult() {
        return getCurrentPlayer().getAcceptAndReject();
    }

    public void showProfileToOtherUsers(String username) {
        boolean found = false;
        Player thisPlayer = null;
        for (Player player : getCurrentPlayer().getFriendList()) {
            if (player.getUsername().equals(username)) {
                thisPlayer = player;
                found = true;
            }
        }
        if (found) {
            System.out.println("user: " + thisPlayer.getUsername() + "\n" +
                    "first name: " + thisPlayer.getFirstName() + ", last name: " + thisPlayer.getLastName() + "\n" +
                    "friends: " + thisPlayer.getFriendList().size() + "\n" +
                    "wins: " + thisPlayer.getWins() + "\n" +
                    "plato age: " + thisPlayer.getPlatoAge());
        }
    }

    public void reportUser(String username) {
        for (Player player : getPlayers()) {
            if (player.getUsername().equals(username)) {
                player.setReports(player.getReports() + 1);
            }
        }
    }

}

