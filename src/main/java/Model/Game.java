package Model;

import java.util.ArrayList;

public class Game {
    private String name;
    private int gameId;
    public static ArrayList<Game> games = new ArrayList<>();
    public Game(String gameName, int gameId) {
        name = gameName;
        this.gameId = gameId;
        games.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
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

}
