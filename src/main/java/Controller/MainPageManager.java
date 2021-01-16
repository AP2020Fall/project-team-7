package Controller;

import Model.Game;
import Model.Person;
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
        System.out.println(getCurrentPlayer().getLastPlayed().toString());
    }

    public void setLastPlayed(Game game) {
        getCurrentPlayer().getLastPlayed().add(game);
        getCurrentPlayer().setLastPlayed(getCurrentPlayer().getLastPlayed());
    }

    public void addFavoriteGame(Game game) {
        getCurrentPlayer().getFavoriteGame().add(game);
        getCurrentPlayer().setFavoriteGame(getCurrentPlayer().getFavoriteGame());
    }

    public void addFriend(Player player, Player currentPlayer) {
        player.getFriendList().add(currentPlayer);
        player.setFriendList(player.getFriendList());
        getCurrentPlayer().getFriendList().add(player);
        getCurrentPlayer().setFriendList(getCurrentPlayer().getFriendList());
    }

    public void sendRequest(String username) {
        for (Person person : Person.getPeople()) {
            if (person.getUsername().equals(username)) {
                person.getRequests().add(getCurrentPlayer().getUsername());
                person.setRequests(person.getRequests());
                break;
            }
        }
    }

    public boolean isThisUserRequest(String username) {
        for (String req : getCurrentPlayer().getRequests()) {
            if (req.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> showRequests() {
        return getCurrentPlayer().getRequests();
    }

    public ArrayList<Player> showFriendList() {
        return getCurrentPlayer().getFriendList();
    }

    public int getWins() {
        return getCurrentPlayer().getWins();
    }

    public void acceptAndReject(String username, boolean accept) {
        for (Player player : getPlayers()) {
            if (player.getUsername().equals(username)) {
                if (accept) {
                    addFriend(player, getCurrentPlayer());
                    player.getAcceptAndReject().add(getCurrentPlayer().getUsername() + " accepted your request;) ");

                } else {
                    player.getAcceptAndReject().add(getCurrentPlayer().getUsername() + " put you away:( ");
                }
                getCurrentPlayer().getRequests().remove(username);//...
                getCurrentPlayer().setAcceptAndReject(player.getAcceptAndReject());
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

