package Model;



import java.util.ArrayList;
import java.util.HashMap;

public class Person {
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    protected String Email;
    protected String phoneNumber;
    protected HashMap<String , String> loginInfo;
    private static ArrayList<Person> people = new ArrayList<>();

    public Person(String username, String password, String email, String fName, String lName, String phoneNum) {
        this.username = username;
        this.password = password;
        this.Email = email;
        people.add(this);
    }
    public static void addPeople(Person person){
        people.add(person);
    }

    public static ArrayList<Person> getPeople() {
        return people;
    }

    public static boolean isPeopleEmpty(){
        return people.isEmpty();
    }
    public Person(String username) {
        this.username = username;
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

    public void setPassword(String password) {
        this.password = password;
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

    public HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(HashMap<String, String> loginInfo) {
        this.loginInfo = loginInfo;
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

    public void getScore() {
    }
}
