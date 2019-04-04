package it.emes.schoolmanagement.library.network;

import it.emes.schoolmanagement.library.school.School;
import it.emes.schoolmanagement.library.users.User;

import java.io.Serializable;

public class Response implements Serializable {

    private int result;
    private User user;
    private School school;

    public Response(int result) {
        this.result = result;
    }

    public Response(int result, User user) {
        this(result);
        this.user = user;
    }

    public Response(int result, School school) {
        this(result);
        this.school = school;
    }

    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                ", user=" + user +
                ", school=" + school +
                '}';
    }

    public int getResult() {
        return result;
    }

    public User getUser() {
        return user;
    }

    public School getSchool() {
        return school;
    }
}
