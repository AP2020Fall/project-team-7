package Plato.Controller;


import Plato.View.GameMenu;

public class GameMenuManager extends Manager {
    public GameMenuManager() {
        menu = new GameMenu(this);
    }


}
