package Plato.View;

import Plato.Controller.MainPageManager;
import Plato.Controller.Manager;
import Plato.Model.Game;

public class GameMenu extends Menu {
    public GameMenu(Manager manager) {
        super(manager);
        showGameMenu();
    }

    private void showGameMenu() {
        System.out.println("games\n:");
        for (int i = 0; i < Game.getGames().size(); i++) {
            System.out.println(Game.getGames().get(i));
        }
        System.out.println(
                (Game.getGames().size() + 1) + ". back\n" +
                        (Game.getGames().size() + 2) + ". profile");
        String input = scanner.nextLine();
        if (Integer.parseInt(input) <= Game.getGames().size()) {
            System.out.println(Game.getGames().get(Integer.parseInt(input)-1));
            System.out.println("1. play\n2. add this game to favorites");
            String choose = scanner.nextLine();
            if (choose.matches("^1$")) {
                System.out.println("playing " + Game.getGames().get(Integer.parseInt(input)-1));
                ((MainPageManager) manager).setLastPlayed(Game.getGames().get(Integer.parseInt(input)-1));
                System.out.println("enter 'back' to return.");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("back"))
                    showGameMenu();
            } else if (choose.matches("^2$")) {
                ((MainPageManager) manager).addFavoriteGame(Game.getGames().get(Integer.parseInt(input)-1));
                System.out.println("added " + Game.getGames().get(Integer.parseInt(input)-1).getName() + " to your favorite game");
                showGameMenu();
            } else {
                showGameMenu();
            }
        } else if (Integer.parseInt(input) == Game.getGames().size() + 1) {
            returnMainPage();
        } else if (Integer.parseInt(input) == Game.getGames().size() + 2) {
            goProfile();
        } else {
            System.err.println("invalid command!");
            showGameMenu();
        }
    }
}
