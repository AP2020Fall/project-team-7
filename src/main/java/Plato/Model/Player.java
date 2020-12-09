package Plato.Model;

import Plato.View.UserView.Friend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Player extends Person{
    private Date registeredDate;
    private int score;
    private int cash;
    private GameLog gameLog;
    private List<Friend> friendList;
    private List<Friend> requests;
    private ArrayList<Game> gamesHistory;

    public Player(String firstName, String lastName, String username, String id,
                  String password, String email, String phoneNumber) {
        super(firstName, lastName, username, id, password, email, phoneNumber);
    }


    private void editProfile(){

    }

    private void login(){

    }

    private void logout(){

    }

    private void participateInEvent(Event event){

    }

    private void leftTheEvent(Event event){

    }

    private void runGame(){

    }

    private void addFriend(){

    }




}
