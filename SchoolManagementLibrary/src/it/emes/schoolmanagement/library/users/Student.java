package it.emes.schoolmanagement.library.users;

import it.emes.schoolmanagement.library.school.SchoolClass;
import it.emes.schoolmanagement.library.school.Subject;

import java.io.Serializable;
import java.util.List;

public class Student extends User implements Serializable {

    private UserType userType = UserType.STUDENT;
    private SchoolClass schoolClass;
    private List<Subject> subjects;

    public Student(String username, String password) {
        super(username, password);
    }

    public Student(String username, String password, String firstname, String lastname, SchoolClass schoolClass) {
        super(username, password, firstname, lastname);
        this.schoolClass = schoolClass;
    }

    public Student(int ID, String username, String password, String firstname, String lastname, SchoolClass schoolClass) {
        super(ID, username, password, firstname, lastname);
        this.schoolClass = schoolClass;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public UserType getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userType=" + userType +
                ", schoolClass=" + schoolClass +
                ", subjects=" + subjects +
                "} " + super.toString();
    }
}
