package it.emes.schoolmanagement.library.network;

import it.emes.schoolmanagement.library.users.*;

import java.io.Serializable;

public class Request implements Serializable {

    RequestType requestType;
    User user;
    UserType userType;
    Staffer staffer;
    Student student;
    Teacher teacher;

    @Override
    public String toString() {
        return "Request{" +
                "requestType=" + requestType +
                ", user=" + user +
                ", userType=" + userType +
                ", staffer=" + staffer +
                ", student=" + student +
                ", teacher=" + teacher +
                '}';
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public User getUser() {
        return user;
    }

    public UserType getUserType() {
        return userType;
    }

    public Staffer getStaffer() {
        return staffer;
    }

    public Student getStudent() {
        return student;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
