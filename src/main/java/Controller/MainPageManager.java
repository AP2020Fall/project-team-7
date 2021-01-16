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
        System.out.println(getCurrentPlayer().getLastPlayed());
    }

    public void setLastPlayed(Game game) {
        getCurrentPlayer().getLastPlayed().add(game);
        getCurrentPlayer().setLastPlayed(getCurrentPlayer().getLastPlayed());
    }

    public void addFavoriteGame(Game game) {
        getCurrentPlayer().getFavoriteGame().add(game);
        getCurrentPlayer().setFavoriteGame(currentPlayer.getFavoriteGame());
    }

    public void addFriend(String username) {
        for (Player player : getCurrentPlayer().getFriendList()) {
            if (player.getUsername().equals(username)) {
                getCurrentPlayer().getFriendList().add(player);
                getCurrentPlayer().setFriendList(getCurrentPlayer().getFriendList());
                break;
            }
        }
    }

    public void sendRequest(String username) {
        for (Player player : getCurrentPlayer().getFriendList()) {
            if (player.getUsername().equals(username)) {
                player.getRequests().add(getCurrentPlayer());
                player.setRequests(player.getRequests());
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
                player.setAcceptAndReject(player.getAcceptAndReject());
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

