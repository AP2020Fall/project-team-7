package Controller;

import Model.Game;
import View.MainPage;

import java.util.ArrayList;

public class MainPageManager extends Manager {

    public MainPageManager() {
        menu = new MainPage(this);
    }

    public void showPoints() {
        System.out.println(currentPlayer.getScore());
    }

    public ArrayList<Game> showFavoriteGame() {
        return currentPlayer.getFavoriteGame();
    }

    public ArrayList<String> showBotMessage() {
        return currentPlayer.getPlatoBotMessage();
    }

    public void viewLastPlayed() {
        for (int i = currentPlayer.getLastPlayed().size() - 1; i >= 0; i--) {
            System.out.println(currentPlayer.getLastPlayed().get(i).toString());
        }
    }

    public void setLastPlayed(Game game) {
        currentPlayer.getLastPlayed().add(game);
    }

    public void addFavoriteGame(Game game) {
        currentPlayer.getFavoriteGame().add(game);
    }

    public void deleteGameFromFavorite(Game game) {
        currentPlayer.getFavoriteGame().remove(game);
    }

}

