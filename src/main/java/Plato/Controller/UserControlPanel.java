package Plato.Controller;

import Plato.Model.*;

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

    public void editUserDetail(Object currentObj, Object newObj){

    }

    public void deleteAccount(String username, String password){

    }

    public void searchFriend(String username){

    }

    public void participateEvent(Event event){

    }

    public void registerUser(Player player){
        players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void viewUserInfo(Player player){
        System.out.println(player.toString());
    }
}

