package Controller;

import Model.Person;
import View.Profile;

public class ProfileManager extends Manager {
    public ProfileManager() {
        menu = new Profile(this);
    }

    public boolean canDeleteAccount(String username, String password) {
        boolean canDelete = false;
        for (Person person : Person.getPeople()) {
            if (person.getUsername().equals(username) && person.getPassword().equals(password)) {
                Person.getPeople().remove(person);
                canDelete = true;
                break;
            }
        }
        return canDelete;
    }

    public void changePassword(String password) {
        getCurrentPlayer().setPassword(password);
    }

    public void changeEmail(String email) {
        getCurrentPlayer().setEmail(email);
    }

    public void changePhoneNum(String phoneNum) {
        getCurrentPlayer().setPhoneNumber(phoneNum);
    }

    public void changeFName(String fName) {
        getCurrentPlayer().setFirstName(fName);
    }

    public void changeLName(String lName) {
        getCurrentPlayer().setLastName(lName);
    }
}
