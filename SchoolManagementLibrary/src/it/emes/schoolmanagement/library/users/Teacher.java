package it.emes.schoolmanagement.library.users;

import it.emes.schoolmanagement.library.school.SchoolClass;
import it.emes.schoolmanagement.library.school.Subject;

import java.io.Serializable;
import java.util.List;

public class Teacher extends User implements Serializable {

    private UserType userType = UserType.TEACHER;
    private List<SchoolClass> schoolClasses;
    private Subject subject;

    public Teacher(String username, String password) {
        super(username, password);
    }

    public Teacher(String username, String password, String firstname, String lastname, Subject subject) {
        super(username, password, firstname, lastname);
        this.subject = subject;
    }

    public Teacher(int ID, String username, String password, String firstname, String lastname, Subject subject) {
        super(ID, username, password, firstname, lastname);
        this.subject = subject;
    }

    public List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public UserType getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "userType=" + userType +
                ", schoolClasses=" + schoolClasses +
                ", subject=" + subject +
                "} " + super.toString();
    }
}
