package Controller;

import Model.Player;
import View.MainPage;

public class MainPageManager extends Manager{
    public MainPageManager() {
        menu = new MainPage(this);
    }

    public void showPoints(){
        System.out.println(currentPlayer.getScore());
    }
}

