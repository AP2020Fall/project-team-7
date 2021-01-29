package Plato.Controller;


import DotsAndBoxes.Dots;
import Plato.Model.Game;
import Plato.View.GameMenu;

public class GameMenuManager extends Manager {
    public GameMenuManager() {
        menu = new GameMenu(this);
    }

    public void setLastPlayed(Game game) {
        getCurrentPlayer().getLastPlayed().add(game);
        getCurrentPlayer().setLastPlayed(getCurrentPlayer().getLastPlayed());
    }

    public void runDotsAndBoxes(){
        new Dots(getCurrentPlayer());
    }

}
