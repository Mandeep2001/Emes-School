package it.emes.schoolmanagement.library.users;

import java.io.Serializable;

public class User implements Serializable {

    private int ID;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private UserType userType = UserType.USER;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User(int ID, String username, String password, String firstname, String lastname) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", userType=" + getUserType() +
                '}';
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public UserType getUserType() {
        return userType;
    }
}
