package Model;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Player extends Person {
    private int platoAge;
    private int score;
    private int cash;
    private ArrayList<GameLog> gameLog;
    private ArrayList<Player> friendList;
    private ArrayList<Player> requests;
    private ArrayList<Game> gamesHistory;
    private ArrayList<String> favoriteGame;
    private ArrayList<String> platoBotMessage;
    private ArrayList<Event> eventsParticipant;

    public Player(String userName, String password, String email, String fName, String lName, String phoneNum) {
        super(userName, password, email, fName, lName, phoneNum);
        firstName = fName;
        lastName = lName;
        phoneNumber = phoneNum;
        Email = email;
        setPassword(password);
        eventsParticipant = new ArrayList<>();
        friendList = new ArrayList<>();
        requests = new ArrayList<>();
        gamesHistory = new ArrayList<>();
        platoBotMessage = new ArrayList<>();
        eventsParticipant = new ArrayList<>();
        platoAge = 0;
        score = 0;
        cash = 0;

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

    public void setPlatoAge(int platoAge) {
        this.platoAge = platoAge;
    }

    public int getPlatoAge() {
        return platoAge;
    }

    @Override
    public String toString() {
        return "user: " + username + "\n" +
                "firstName='" + firstName + '\'' + "\n" +
                "lastName='" + lastName + '\'' + "\n" +
                "username='" + username + '\'' + "\n" +
                "Email='" + Email + '\'' + "\n" +
                "phoneNumber='" + phoneNumber + '\'';
    }



}
