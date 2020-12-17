package Plato.View.Menu;

import java.util.HashMap;

public class GameMenu extends Menu{
    public GameMenu(String name, Menu parentMenu) {
        super(name, parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, showGame());
        submenus.put(2, showScoreBoard());
        submenus.put(3,showDetails());
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
//complete from here
    private Menu showScoreBoard(){
        return new Menu("score board", this) {
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

    private Menu showDetails(){
        return new Menu("details", this) {
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

    private Menu showLog(){
        return new Menu("Log", this) {
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

    private Menu showWinsCount(){
        return new Menu("wins count", this) {
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

    private Menu showPlayedCount(){
        return new Menu("played count", this) {
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

    private Menu addToFavorite(){
        return new Menu("add to favorite games", this) {
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

    private Menu runGame(){
        return new Menu("run game", this) {
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

    private Menu showPoints(){
        return new Menu("show point", this) {
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
}
