package Controller;

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
        for (Player player : players) {
            if (player.getUsername().equals(username) && player.getPassword().equals(password)) {
                canDelete = true;
                players.remove(player);
                break;
            }
        }
        return canDelete;
    }
}
