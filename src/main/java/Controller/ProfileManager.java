package Controller;

import Model.Person;
import Model.Player;
import View.Profile;

public class ProfileManager extends Manager {
    public ProfileManager() {
        menu = new Profile(this);
    }

    public void   showPersonalInfo() {
        System.out.println(currentPlayer.toString());
    }

    public boolean canDeleteAccount(String username, String password) {
        boolean canDelete = false;
        for (Person person : Person.getPeople()) {
            if (person.getUsername().equals(username) && person.getPassword().equals(password)) {
                Person.getPeople().remove(person);
                players.remove(person);
                canDelete = true;
                break;
            }
        }
        return canDelete;
    }
}
