package Controller;

import Model.Game;
import View.MainPage;
import java.util.ArrayList;

public class MainPageManager extends Manager{

    public MainPageManager() {
        menu = new MainPage(this);
    }

    public void showPoints(){
        System.out.println(currentPlayer.getScore());
    }

    public ArrayList<String> showFavoriteGame(){
        return currentPlayer.getFavoriteGame();
    }

    public ArrayList<String > showBotMessage(){
        return currentPlayer.getPlatoBotMessage();
    }

    public Game viewLastPlayed(){
        return currentPlayer.getLastPlayed();
    }

    public void setLastPlayed(Game gameName){
        currentPlayer.setLastPlayed(gameName);
    }

}

