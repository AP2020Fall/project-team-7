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
        System.out.println(currentPlayer.getScore());
    }

    public ArrayList<Game> showFavoriteGame() {
        return currentPlayer.getFavoriteGame();
    }

    public ArrayList<String> showBotMessage() {
        return currentPlayer.getPlatoBotMessage();
    }

    public void viewLastPlayed() {
        for (int i = currentPlayer.getLastPlayed().size() - 1; i >= 0; i--) {
            System.out.println(currentPlayer.getLastPlayed().get(i).toString());
        }
    }

    public void setLastPlayed(Game game) {
        currentPlayer.getLastPlayed().add(game);
    }

    public void addFavoriteGame(Game game) {
        currentPlayer.getFavoriteGame().add(game);
    }

    //this func must send request
    public void addFriend(String username) {
        for (Player player : currentPlayer.getFriendList()) {
            if (player.getUsername().equals(username)) {
                currentPlayer.getFriendList().add(player);
                break;
            }
        }
    }

    public void sendRequest(String username) {
        for (Player player : currentPlayer.getFriendList()) {
            if (player.getUsername().equals(username)) {
                player.getRequests().add(currentPlayer.getUsername());
                break;
            }
        }
    }

    public boolean isThisUserRequest(String username){
        for (Player player : currentPlayer.getFriendList()) {
            if (player.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void showRequests() {
        for (int i = 0; i < currentPlayer.getRequests().size(); i++) {
            System.out.println((i + 1) + currentPlayer.getRequests().get(i) + " wants to be your friend!");
        }
    }

    public void showFriendList() {
        System.out.println(currentPlayer.getFriendList());
    }

    public int getWins() {
        return currentPlayer.getWins();
    }

    public void acceptAndReject(String username, boolean accept){
        for (Player player : getPlayers()) {
            if (player.getUsername().equals(username)){
                if (accept){
                    player.getAcceptAndReject().add(currentPlayer.getUsername() + " accepted your request!");
                } else {
                    player.getAcceptAndReject().add(currentPlayer.getUsername() + " put you away :(");
                }
                break;
            }
        }
    }

    public ArrayList<String> showRequestResult(){
        return currentPlayer.getAcceptAndReject();
    }

}

