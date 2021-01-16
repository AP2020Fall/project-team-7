package Controller;

import Model.Admin;
import Model.Person;
import Model.Player;
import View.RegisterMenu;

public class RegisterManager extends Manager {

    public RegisterManager() {
        menu = new RegisterMenu(this);

    }

    public void createNewAccount(String username, String password, String email, String fName, String lName, String phoneNum) {
        if (isThisAdmin()) {
            Admin admin = new Admin(username, password, email, fName, lName, phoneNum);
            setPerson(admin);
            setAdmin(admin);
        } else {
            Player player = new Player(username, password, email, fName, lName, phoneNum);
            setPerson(player);
            setCurrentPlayer(player);
        }
    }

    public boolean isThisAdmin() {
        return Person.getPeople().isEmpty();
    }

}
