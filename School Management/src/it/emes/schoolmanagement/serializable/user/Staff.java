package it.emes.schoolmanagement.serializable.user;

import it.emes.schoolmanagement.database.dao.StaffDAO;

import java.io.Serializable;
import java.sql.SQLException;

public class Staff extends User implements Serializable {

    private UserType userType = UserType.STAFF;
    private StaffDAO staffDAO = new StaffDAO();

    public Staff() {}

    public Staff(String username, String password) {
        super(username, password);
    }

    public Staff(int ID, String username, String password, String firstname, String lastname) {
        super(ID, username, password, firstname, lastname);
    }


    /**
     * Questo metodo aggiunge uno studente al database
     * @param student oggetto studente da aggiungere al database
     * @throws SQLException eccezione sql
     */
    public void addStudent(Student student) throws SQLException {
        staffDAO.addStudent(student);
    }

    /**
     * Questo metodo aggiunge un teacher al database
     * @param teacher oggetto teacher da aggiungere al database
     * @throws SQLException eccezione sql
     */
    public void addTeacher(Teacher teacher) throws SQLException {
        staffDAO.addTeacher(teacher);
    }

    /**
     * Questo metodo aggiunge uno staffer al database
     * @param staff oggetto staff da aggiungere al database
     * @throws SQLException eccezione sql
     */
    public void addStaff(Staff staff) throws SQLException {
        staffDAO.addStaff(staff);
    }

    /**
     * Questo metodo elimina un utente dal database
     * @param user user da eliminare dal database
     * @throws SQLException eccezione sql
     */
    public void deleteUser(User user) throws SQLException {
        staffDAO.deleteUser(user);
    }

    public void updateStudent(Student student) throws SQLException {
        staffDAO.updateStudent(student);
    }

    public void updateTeacher(Teacher teacher) throws SQLException {
        staffDAO.updateTeacher(teacher);
    }

    public void updateStaffer(Staff staff) throws SQLException {
        staffDAO.updateStaff(staff);
    }

    @Override
    public UserType getUserType() {
        return userType;
    }
}
