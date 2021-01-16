package Controller;

import View.GameMenu;

public class GameMenuManager extends Manager {
    public GameMenuManager() {
        menu = new GameMenu(this);
    }

}
