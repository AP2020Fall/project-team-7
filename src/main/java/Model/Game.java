package Model;

import java.util.ArrayList;

public class Game {
    private String gameName;
    private int gameId;
    public static ArrayList<Game> games = new ArrayList<>();

    public Game(String name, int gameId) {
        gameName = name;
        this.gameId = gameId;
        games.add(this);
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

    private void setScore(){

    }

    public static ArrayList<Game> getGames() {
        return games;
    }

    @Override
    public String toString() {
        return gameId + ". " + gameName;
    }
}
