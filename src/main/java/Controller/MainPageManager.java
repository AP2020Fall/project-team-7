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

    public void addFavoriteGame(Game game) {
        getCurrentPlayer().getFavoriteGame().add(game);
        getCurrentPlayer().setFavoriteGame(getCurrentPlayer().getFavoriteGame());
    }

    public void addFriend(Player player) {
        currentPlayer.addFriend(player);
    }

    public void removeFriend(String username){
        for (Player player : currentPlayer.getFriendList()) {
            if (player.getUsername().equals(username)){
                currentPlayer.getFriendList().remove(player);
                break;
            }
        }
    }

    public void setLastPlayed(Game game) {
        getCurrentPlayer().getLastPlayed().add(game);
        getCurrentPlayer().setLastPlayed(getCurrentPlayer().getLastPlayed());
    }

    public void sendRequest(String username) {
        for (Person person : Person.getPeople()) {
            if (person.getUsername().equals(username)) {
                person.addRequest(getCurrentPlayer().getUsername());
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
        return currentPlayer.getFriendList();
    }

    public int getWins() {
        return getCurrentPlayer().getWins();
    }

    public void acceptAndReject(String username, boolean accept) {
        for (Player player : getPlayers()) {
            if (player.getUsername().equals(username)) {
                player.requestResult(currentPlayer, accept);
                addFriend(player);
                break;
            }
        }
        getCurrentPlayer().removeRequest(username);
    }

    public ArrayList<String> showRequestResult() {
        return currentPlayer.getAcceptAndReject();
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

