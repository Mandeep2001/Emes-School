package it.emes.schoolmanagement.serializable.user;

import it.emes.schoolmanagement.database.dao.StudentDAO;
import it.emes.schoolmanagement.serializable.school.*;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class Student extends User implements Serializable {

    private UserType userType = UserType.STUDENT;
    private SchoolClass schoolClass;
    private List<Subject> subjects;
    private StudentDAO studentDAO = new StudentDAO();

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

    /**
     * Questo metodo restituisce una lista di voti
     * @return restituisce la lista dei voti dello studente
     * @throws SQLException Eccezione SQL
     */
    public List<Vote> getVotes() throws SQLException {
        return studentDAO.getVotes(this);
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public UserType getUserType() {
        return userType;
    }
}
