package Plato.Controller;

import Plato.Model.Game;
import Plato.Model.PlatoBot;
import Plato.Model.Player;

import java.util.ArrayList;

public class UserControlPanel {
    private ArrayList<Player> players;

    public int showPoints(Player player){
        return player.getScore();
    }

    public ArrayList<Game> viewFavoriteGame(Player player){
        return player.getFavoriteGame();
    }

    public ArrayList<String> viewPlatoBotMessage(Player player){
        return player.getPlatoBotMessage();
    }
}
