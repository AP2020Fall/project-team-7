package Controller;

import Model.Person;
import Model.Player;
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
                players.remove(person);
                canDelete = true;
                break;
            }
        }
        return canDelete;
    }

    public void changePassword(String password){
        currentPerson.setPassword(password);
    }

    public void changeEmail(String email){
        currentPerson.setEmail(email);
    }

    public void changePhoneNum(String phoneNum){
        currentPerson.setPhoneNumber(phoneNum);
    }

    public void changeFName(String fName){
        currentPerson.setFirstName(fName);
    }

    public void changeLName(String lName){
        currentPerson.setLastName(lName);
    }
}
