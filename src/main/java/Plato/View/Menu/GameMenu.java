package Plato.View.Menu;

import java.util.HashMap;

public class GameMenu extends Menu{
    public GameMenu(String name, Menu parentMenu) {
        super(name, parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, showGame());
        this.setSubmenus(submenus);
    }

    private Menu showGame() {
        return new Menu("Games", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println(manager.getGames());
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {

                    this.show();
                    this.execute();
                }
            }
        };
    }

    private void showScoreBoard(){

    }

    private void showDetails(){

    }

    private void showLog(){

    }

    private void showWinsCount(){

    }

    private void showPlayedCount(){

    }

    private void addToFavorite(){

    }

    private void runGame(){

    }

    private void showPoints(){

    }
}
