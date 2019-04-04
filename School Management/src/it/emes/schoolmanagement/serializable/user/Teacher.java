package it.emes.schoolmanagement.serializable.user;

import it.emes.schoolmanagement.database.dao.TeacherDAO;
import it.emes.schoolmanagement.serializable.school.School;
import it.emes.schoolmanagement.serializable.school.SchoolClass;
import it.emes.schoolmanagement.serializable.school.Subject;
import it.emes.schoolmanagement.serializable.school.Vote;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends User implements Serializable {

    private UserType userType = UserType.TEACHER;
    private List<SchoolClass> schoolClasses;
    private Subject subject;
    private TeacherDAO teacherDAO = new TeacherDAO();

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

    /**
     * Questo metodo aggiunge una nuova SchoolClass alla lista delle SchoolClass dell'insegnante
     * @param schoolClass classe da aggiungere
     */
    public void addClass(SchoolClass schoolClass) {
        this.schoolClasses.add(schoolClass);
    }

    /**
     * Questo metodo rimuove la SchoolClass passata come paramentro dalla lista SchoolClasses dell'insegante
     * @param schoolClass classe da rimuovere
     */
    public void removeClass(SchoolClass schoolClass) {
        this.schoolClasses.remove(schoolClass);
    }

    /**
     * Questo metodo aggiunge un voto ad uno studente
     * @param student Studente al quale aggiungere il voto
     * @param vote {@code} Voto da aggiungere
     * @throws SQLException Eccezione SQL
     */
    public void addVote(Student student, double vote) throws SQLException {
        teacherDAO.addVote(this, student, vote);
    }

    /**
     * Rimuove il voto passato come parametro.
     * @param vote voto da eliminare.
     * @throws SQLException eccezione sql.
     */
    public void removeVote(Vote vote) throws SQLException {
        teacherDAO.removeVote(vote);
    }

    /**
     * Questo metodo restituisce una lista contente tutti gli studenti di una classe
     * @param schoolClass classe di cui cercare gli utenti
     * @return Lista degli utenti della classe passata come parametro
     */
    public List<Student> getClassStudents(SchoolClass schoolClass) {
        List<Student> students = new ArrayList<>();
        for (Student st : School.getStudents()) {
            if (st.getSchoolClass().getClassID() == schoolClass.getClassID())
                students.add(st);
        }
        return students;
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
}
