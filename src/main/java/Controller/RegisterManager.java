package Controller;

import Model.Admin;
import Model.Person;
import Model.Player;
import View.AccountMenu;
import View.RegisterMenu;

import java.util.HashMap;

public class RegisterManager extends Manager{

    public RegisterManager() {
        menu = new RegisterMenu(this);

    }


    public void createNewAccount(String username, String password, String email, String fName, String lName, String phoneNum) {
        if (isThisAdmin()){
            Admin admin = new Admin(username, password, email, fName, lName, phoneNum);
            Person.addPeople(admin);
            setPerson(admin);
            setAdmin(admin);
        } else {
            Player player = new Player(username, password, email, fName, lName, phoneNum);
            Person.addPeople(player);
            setPerson(player);
            setCurrentPlayer(player);
        }
    }

    private boolean isInputValid(String email, String phoneNum){
        if (!checkEmail(email)){
            return false;
        }
        if (!checkPhoneNumber(phoneNum)){
            return false;
        }
        return true;
    }

    public boolean isThisUsernameExist(String username){
        for (Person person : Person.getPeople()) {
            if (person.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public boolean isThisAdmin(){
        if (Person.getPeople().isEmpty()){
            return true;
        }
        return false;
    }

}
