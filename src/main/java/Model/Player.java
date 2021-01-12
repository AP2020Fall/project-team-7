package Model;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Player extends Person {
    private Date platoAge;
    private int score = 0;
    private int cash = 0;
    private ArrayList<GameLog> gameLog;
    private ArrayList<Player> friendList;
    private ArrayList<Player> requests;
    private ArrayList<Game> gamesHistory;
    private ArrayList<String> favoriteGame;
    private ArrayList<String> platoBotMessage;
    private ArrayList<Event> eventsParticipant;

    public Player(String username, String password, String email, String fName, String lName, String phoneNum) {
        super(username, password, email, fName, lName, phoneNum);
    }

    public Player(String username) {
        super(username);
        eventsParticipant = new ArrayList<>();
        friendList = new ArrayList<>();
        requests = new ArrayList<>();
        gamesHistory = new ArrayList<>();
        platoBotMessage = new ArrayList<>();
        eventsParticipant = new ArrayList<>();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private void participateInEvent(Event event) {
        eventsParticipant.add(event);
    }

    private void leftTheEvent(Event event) {
        eventsParticipant.remove(event);
    }

    private void runGame() {

    }

    private void addFriend(Player username) {
        friendList.add(username);
    }


    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public ArrayList<GameLog> getGameLog() {
        return gameLog;
    }

    public void setGameLog(ArrayList<GameLog> gameLog) {
        this.gameLog = gameLog;
    }

    public ArrayList<Player> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<Player> friendList) {
        this.friendList = friendList;
    }

    public ArrayList<Player> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<Player> requests) {
        this.requests = requests;
    }

    public ArrayList<Game> getGamesHistory() {
        return gamesHistory;
    }

    public void setGamesHistory(ArrayList<Game> gamesHistory) {
        this.gamesHistory = gamesHistory;
    }

    public ArrayList<String > getFavoriteGame() {
        return favoriteGame;
    }

    public void setFavoriteGame(ArrayList<String> favoriteGame) {
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
        return "Player{" + "\n" +
                "firstName='" + firstName + '\'' + "\n" +
                ", lastName='" + lastName + '\'' + "\n" +
                ", username='" + username + '\'' + "\n" +
                ", Email='" + Email + '\'' + "\n" +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }



}
