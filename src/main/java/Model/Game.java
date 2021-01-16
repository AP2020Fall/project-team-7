package Model;

import java.util.ArrayList;

public class Game {
    public static ArrayList<Game> games = new ArrayList<>();
    private String gameName;
    private int gameId;

    public Game(String name, int gameId) {
        gameName = name;
        this.gameId = gameId;
        games.add(this);
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
