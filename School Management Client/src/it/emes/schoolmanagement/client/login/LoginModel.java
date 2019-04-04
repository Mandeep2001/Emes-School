package it.emes.schoolmanagement.client.login;

import it.emes.schoolmanagement.client.network.RequestService;
import it.emes.schoolmanagement.library.network.Request;
import it.emes.schoolmanagement.library.network.RequestBuilder;
import it.emes.schoolmanagement.library.network.RequestType;
import it.emes.schoolmanagement.library.network.Response;
import it.emes.schoolmanagement.library.school.School;
import it.emes.schoolmanagement.library.users.User;

class LoginModel {

    private User user;
    private School school;

    public LoginModel() {
        load();
    }

    public void load() {
        RequestBuilder requestBuilder = new RequestBuilder(RequestType.LOAD);
        RequestService loadRequest = new RequestService(requestBuilder.build());
        loadRequest.setOnSucceeded(event -> setSchool(loadRequest.getValue().getSchool()));
        loadRequest.start();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public School getSchool() {
        return school;
    }

    private void setSchool(School school) {
        this.school = school;
    }
}
