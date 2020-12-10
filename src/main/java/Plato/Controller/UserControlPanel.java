package Plato.Controller;

import Plato.Model.Admin;
import Plato.Model.Game;
import Plato.Model.PlatoBot;
import Plato.Model.Player;

import java.util.ArrayList;

public class UserControlPanel {
    private ArrayList<Player> players;
    Admin admin;

    public int showPoints(Player player){
        return player.getScore();
    }

    public ArrayList<Game> viewFavoriteGame(Player player){
        return player.getFavoriteGame();
    }

    public ArrayList<String> viewPlatoBotMessage(Player player){
        return player.getPlatoBotMessage();
    }

    public String viewLastGame(Player player){
        //return last game that played
        return "";
    }

    public ArrayList<String> viewAdminSuggestion(){
        return admin.getAdminSuggestion();
    }

    public void chooseSuggestedGame(){

    }

    public void addFriend(Player currentUser, Player player){
        ArrayList friendList = new ArrayList();
        friendList = currentUser.getFriendList();
        friendList.add(player);
        currentUser.setFriendList(friendList);
    }
}
