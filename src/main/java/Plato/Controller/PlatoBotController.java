package Plato.Controller;

import Plato.Model.Player;

import java.util.ArrayList;

public class PlatoBotController {
    private ArrayList<String> message;
    Manager manager = new Manager();

    public ArrayList<String> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<String> message) {
        this.message = message;
    }

    public boolean checkEmail(String email) {
        if (email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
            return true;
        }
        return false;
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("09\\d{9}")) {
            return true;
        }
        return false;
    }

    public boolean checkPassword(String password) {
        if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$")) {
            return true;
        }
        return false;
    }

    public boolean isThisUsernameExist(String username){
        if (manager.getAllUsers().size()==0){
            return false;
        }else {
            for (Player allUser : manager.getAllUsers()) {
                if (allUser.getUsername().equalsIgnoreCase(username)) {
                    return true;
                }
            }
        }
        return false;
    }
}
