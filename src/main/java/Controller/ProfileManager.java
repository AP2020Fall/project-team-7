package Controller;

import View.Profile;

public class ProfileManager extends Manager
{
    public ProfileManager() {
        menu = new Profile(this);
    }
}
