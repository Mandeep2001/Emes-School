package it.emes.schoolmanagement.server.database.dao;

import it.emes.schoolmanagement.library.users.Staffer;
import it.emes.schoolmanagement.library.users.Student;
import it.emes.schoolmanagement.library.users.Teacher;
import it.emes.schoolmanagement.library.users.User;
import it.emes.schoolmanagement.server.database.handler.Connect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StafferDAO {

    PreparedStatement preparedStatement;

    public int addStudent(Student student) {
        try {
            preparedStatement = Connect.getConnection().prepareStatement(
                    "INSERT INTO students (username, password, firstname, lastname, classID) " +
                            "VALUES (?, ?, ?, ?, ?)");
            setupStatement(preparedStatement, student);
            preparedStatement.setInt(5, student.getSchoolClass().getClassID());
            preparedStatement.execute();
            return 0;
        } catch (SQLException ex) {
            System.err.println("Errore durante l'aggiunta dello studente.." + ex.getMessage());
            return 1;
        }
    }

    public int addTeacher(Teacher teacher) {
        try {
            preparedStatement = Connect.getConnection().prepareStatement(
                    "INSERT INTO teachers (username, password, firstname, lastname, subjectID) " +
                            "VALUES (?, ?, ?, ?, ?)");
            setupStatement(preparedStatement, teacher);
            preparedStatement.setInt(5, teacher.getSubject().getID());
            preparedStatement.execute();
            return 0;
        } catch (SQLException ex) {
            System.err.println("Errore durante l'aggiunta dell'insegnante.." + ex.getMessage());
            return 1;
        }
    }

    public int addStaffer(Staffer staffer) {
        try {
            preparedStatement = Connect.getConnection().prepareStatement(
                    "INSERT INTO staffers (username, password, firstname, lastname) " +
                            "VALUES (?, ?, ?, ?)");
            setupStatement(preparedStatement, staffer);
            preparedStatement.execute();
            return 0;
        } catch (SQLException ex) {
            System.err.println("Errore durante l'aggiunta dello studente.." + ex.getMessage());
            return 1;
        }
    }

    private void setupStatement(PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getFirstname());
        preparedStatement.setString(4, user.getLastname());
    }

}
