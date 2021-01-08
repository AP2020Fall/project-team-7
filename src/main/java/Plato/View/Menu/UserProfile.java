package Plato.View.Menu;

import java.util.HashMap;

public class UserProfile extends Menu {

    public UserProfile(Menu parentMenu) {
        super("profile", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, viewProfile());
        submenus.put(2, new LoginMenu(this));
        this.setSubmenus(submenus);

    }


    private Menu viewProfile() {
        return new Menu("profile", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("enter back to return");
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

    private Menu viewFavoriteGame(){
        return new Menu("favorite games", this) {
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

    private Menu viewPlatoBotMessage(){
        return new Menu("plato bot message", this) {
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

    private Menu viewLastPlayed(){
        return new Menu("last played game", this) {
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

    private Menu viewAdminSuggestion(){
        return new Menu("Admin suggestion", this) {
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

    private Menu chooseSuggestedGame(){
        return new Menu("choose suggested game", this) {
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

    private Menu addFriend(){
        return new Menu("add friend", this) {
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
