package Model;


import java.util.ArrayList;
import java.util.HashMap;

public class Person {
    private static ArrayList<Person> people = new ArrayList<>();
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    protected String Email;
    protected String phoneNumber;
    protected HashMap<String, String> loginInfo;
    protected ArrayList<String> acceptAndReject;
    protected ArrayList<Player> requests;

    public Person(String username, String password, String email, String fName, String lName, String phoneNum) {
        this.username = username;
        this.password = password;
        this.Email = email;
        acceptAndReject = new ArrayList<>();
        requests = new ArrayList<>();
        people.add(this);
    }

    public Person(String username) {
        this.username = username;
    }

    public static ArrayList<Person> getPeople() {
        return people;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(HashMap<String, String> loginInfo) {
        this.loginInfo = loginInfo;
    }

    public ArrayList<String> getAcceptAndReject() {
        return acceptAndReject;
    }

    public void setAcceptAndReject(ArrayList<String> acceptAndReject) {
        this.acceptAndReject = acceptAndReject;
    }

    public ArrayList<Player> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<Player> requests) {
        this.requests = requests;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", Email='" + Email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

}
