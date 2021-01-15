package Model;


import java.util.ArrayList;

public class Player extends Person {
    private int platoAge;
    private int score;
    private int wins;
    private int reports;
    private ArrayList<Game> lastPlayed;
    private ArrayList<GameLog> gameLog;
    private ArrayList<Player> friendList;
    private ArrayList<Player> requests;
    private ArrayList<String> acceptAndReject;
    private ArrayList<Game> gamesHistory;
    private ArrayList<Game> favoriteGame;
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
        acceptAndReject = new ArrayList<>();
        platoAge = 0;
        score = 0;
        wins = 0;
        lastPlayed = null;
        reports = 0;
    }

    public int getReports() {
        return reports;
    }

    public void setReports(int reports) {
        this.reports = reports;
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

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
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

    public int getPlatoAge() {
        return platoAge;
    }

    public void setPlatoAge(int platoAge) {
        this.platoAge = platoAge;
    }

    public ArrayList<Game> getLastPlayed() {
        return lastPlayed;
    }

    public void setLastPlayed(ArrayList<Game> lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public ArrayList<String> getAcceptAndReject() {
        return acceptAndReject;
    }

    public void setAcceptAndReject(ArrayList<String> acceptAndReject) {
        this.acceptAndReject = acceptAndReject;
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
