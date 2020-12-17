package Plato.Model;

import Plato.View.UserView.Friend;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Player extends Person{
    private Date platoAge;
    private int score;
    private int cash;
    private GameLog gameLog;
    private ArrayList<Friend> friendList;
    private ArrayList<Friend> requests;
    private ArrayList<Game> gamesHistory;
    private ArrayList<Game> favoriteGame;
    private ArrayList<String> platoBotMessage;

    public Player(String firstName, String lastName, String username, String id,
                  String password, String email, String phoneNumber) {
        super(firstName, lastName, username, id, password, email, phoneNumber);
    }

    public Player(String username) {
        super(username);
    }

    public void editProfile(){

    }

    private void login(){

    }

    private void logout(){

    }

    private void participateInEvent(Event event){

    }

    private void leftTheEvent(Event event){

    }

    private void runGame(){

    }

    private void addFriend(Player username){

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public GameLog getGameLog() {
        return gameLog;
    }

    public void setGameLog(GameLog gameLog) {
        this.gameLog = gameLog;
    }

    public ArrayList<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<Friend> friendList) {
        this.friendList = friendList;
    }

    public ArrayList<Friend> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<Friend> requests) {
        this.requests = requests;
    }

    public ArrayList<Game> getGamesHistory() {
        return gamesHistory;
    }

    public void setGamesHistory(ArrayList<Game> gamesHistory) {
        this.gamesHistory = gamesHistory;
    }

    public ArrayList<Game> getFavoriteGame() {
        return favoriteGame;
    }

    public void setFavoriteGame(ArrayList<Game> favoriteGame) {
        this.favoriteGame = favoriteGame;
    }

    public ArrayList<String> getPlatoBotMessage() {
        return platoBotMessage;
    }

    public void setPlatoBotMessage(ArrayList<String> platoBotMessage) {
        this.platoBotMessage = platoBotMessage;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", Id='" + Id + '\'' +
                ", Email='" + Email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

}
