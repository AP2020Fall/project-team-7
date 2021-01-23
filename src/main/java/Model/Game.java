package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    public static ArrayList<Game> games = new ArrayList<>();
    private String gameName;
    private int gameId;
    private static HashMap<Game, GameInfo> gameInfo;

    public Game(String name, int gameId) {
        gameName = name;
        this.gameId = gameId;
        games.add(this);
        gameInfo = new HashMap<>();
    }

    public static ArrayList<Game> getGames() {
        return games;
    }

    public String getName() {
        return gameName;
    }

    public void setName(String name) {
        gameName = name;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    private void setScore() {

    }

    @Override
    public String toString() {
        return gameId + ". " + gameName;
    }
}

class GameInfo{
    private Game game;
    private String description;
    private int wins;
    private int playingCount;

    public GameInfo(Game game) {
        this.game = game;
        description = "description: ";
        wins = 0;
        playingCount = 0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getPlayingCount() {
        return playingCount;
    }

    public void setPlayingCount(int playingCount) {
        this.playingCount = playingCount;
    }
}