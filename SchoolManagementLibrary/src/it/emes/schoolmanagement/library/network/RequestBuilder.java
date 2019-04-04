package it.emes.schoolmanagement.library.network;

import it.emes.schoolmanagement.library.users.*;

public class RequestBuilder {

    private RequestType requestType;
    private User user;
    private UserType userType;
    private Staffer staffer;
    private Student student;
    private Teacher teacher;

    public RequestBuilder(RequestType requestType) {
        this.requestType = requestType;
    }

    public RequestBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    public RequestBuilder setUserType(UserType userType) {
        this.userType = userType;
        return this;
    }

    public RequestBuilder setStaffer(Staffer staffer) {
        this.staffer = staffer;
        return this;
    }

    public RequestBuilder setStudent(Student student) {
        this.student = student;
        return this;
    }

    public RequestBuilder setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    public Request build() {
        Request request = new Request();
        request.requestType = requestType;
        request.user = this.user;
        request.userType = this.userType;
        request.staffer = this.staffer;
        request.teacher = this.teacher;
        request.student = this.student;
        return request;
    }
}
