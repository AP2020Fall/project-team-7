package Plato.View.Menu;

import Plato.Controller.Manager;
import Plato.View.Main;

public class UserProfile extends Menu {

    public UserProfile(Menu parentMenu) {
        super("profile", parentMenu);
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

    private void showPoints(){

    }

    private void viewFavoriteGame(){

    }

    private void viewPlatoBotMessage(){

    }

    private void viewLastPlayed(){

    }

    private void viewAdminSuggestion(){

    }

    private void chooseSuggestedGame(){

    }

    private void addFriend(){

    }
}
