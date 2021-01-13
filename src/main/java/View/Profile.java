package View;

import Controller.Manager;

public class Profile extends Menu {
    public Profile(Manager manager) {
        super(manager);
        System.out.println("Enter 1 to go to Main page!" +
                "plato age: " + manager.getCurrentPlayer().getPlatoAge() + "\n" +
                "friends: " + manager.getCurrentPlayer().getFriendList().size() + "\n" +
                "score: " + manager.getCurrentPlayer().getScore() + "\n" +
                "1. Main page");
        String input = "";
        while (!(input = scanner.nextLine()).matches("^1$")){
            System.err.println("invalid input! enter 1 to go Main page:");
        }
        returnMainPage();
    }
}
