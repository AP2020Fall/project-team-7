package Plato.Model;

public class GameLog extends Player {
    private int numberOfPlaying;
    private int numberOfWins;
    private String logId;
    private int score;

    public GameLog(String firstName, String lastName, String username,
                   String id, String password, String email, String phoneNumber) {
        super(firstName, lastName, username, password, email, phoneNumber);
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public int getNumberOfPlaying() {
        return numberOfPlaying;
    }


}
