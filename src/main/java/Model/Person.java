package Model;


import java.util.ArrayList;

public class Person {
    private static ArrayList<Person> people = new ArrayList<>();
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    protected String Email;
    protected String phoneNumber;
    protected ArrayList<String> acceptAndReject;
    protected ArrayList<String> requests;

    public Person(String username, String password, String email, String fName, String lName, String phoneNum) {
        this.firstName = fName;
        this.lastName = lName;
        this.phoneNumber = phoneNum;
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

    public ArrayList<String> getAcceptAndReject() {
        return acceptAndReject;
    }

    public void setAcceptAndReject(ArrayList<String> acceptAndReject) {
        this.acceptAndReject = acceptAndReject;
    }

    public ArrayList<String> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<String> requests) {
        this.requests = requests;
    }

    public void addRequest(String username){
        this.requests.add(username);
    }

    public void removeRequest(String username){
        this.requests.remove(username);
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
