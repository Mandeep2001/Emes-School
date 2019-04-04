package it.emes.schoolmanagement.client.staffer.models;

import it.emes.schoolmanagement.client.network.RequestService;
import it.emes.schoolmanagement.library.network.Request;
import it.emes.schoolmanagement.library.network.RequestBuilder;
import it.emes.schoolmanagement.library.network.RequestType;
import it.emes.schoolmanagement.library.network.Response;
import it.emes.schoolmanagement.library.school.School;
import it.emes.schoolmanagement.library.users.Staffer;
import it.emes.schoolmanagement.library.users.Student;
import it.emes.schoolmanagement.library.users.User;
import it.emes.schoolmanagement.library.users.UserType;

public class MainModel {

    private Staffer staffer;
    private School school;
    private Response response;
    private final String BASE_PASS = "1234";
    private User user;
    private Student student;

    public MainModel() {}

    public MainModel(Staffer staffer, School school) {
        this.staffer = staffer;
        this.school = school;
    }

    public void addStudent(String firstName, String lastName, String username, String className) {
        RequestBuilder requestBuilder = new RequestBuilder(RequestType.ADD_USER)
                .setUserType(UserType.STUDENT)
                .setStudent(new Student(username, BASE_PASS, firstName, lastName, school.getSchoolClass(className)))
                .setStaffer(this.staffer);
        RequestService addRequest = new RequestService(requestBuilder.build());
        addRequest.setOnSucceeded(event -> {
            response = addRequest.getValue();
            school = response.getSchool();
            System.out.println(addRequest.getValue().getResult());
        });
        addRequest.start();
    }

    public School getSchool() {
        return school;
    }

    public Staffer getStaffer() {
        return staffer;
    }

    public void setStaffer(Staffer staffer) {
        this.staffer = staffer;
    }

    public String getBASE_PASS() {
        return BASE_PASS;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
