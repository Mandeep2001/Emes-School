package it.emes.schoolmanagement.database.dao;

import it.emes.schoolmanagement.database.Connect;
import it.emes.schoolmanagement.serializable.user.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StaffDAO {

    private PreparedStatement preparedStatement;

    private void setUser(PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getFirstname());
        preparedStatement.setString(4, user.getLastname());
    }

    public boolean addStudent(Student student) throws SQLException {
        preparedStatement = Connect.getConnection().prepareStatement(
                "INSERT INTO students (username, password, firstname, lastname, classID) VALUES (?, ?, ?, ?, ?);");
        setUser(preparedStatement, student);
        preparedStatement.setInt(5, student.getSchoolClass().getClassID());

        return preparedStatement.execute();
    }

    public boolean addTeacher(Teacher teacher) throws SQLException {
        preparedStatement = Connect.getConnection().prepareStatement(
                "INSERT INTO teachers (username, password, firstname, lastname, subjectID) VALUES (?, ?, ?, ?, ?);");
        setUser(preparedStatement, teacher);
        preparedStatement.setInt(5, teacher.getSubject().getID());

        return preparedStatement.execute();
    }

    public boolean addStaff(Staff staff) throws SQLException {
        preparedStatement = Connect.getConnection().prepareStatement(
                "INSERT INTO staffers (username, password, firstname, lastname) VALUES (?, ?, ?, ?);");
        setUser(preparedStatement, staff);
        return preparedStatement.execute();
    }

    public boolean deleteUser(User user) throws SQLException {
        String sql = null;

        switch (user.getUserType()) {
            case STUDENT:
                sql = "DELETE FROM students WHERE id = ?";
                break;
            case TEACHER:
                sql = "DELETE FROM teachers WHERE id = ?";
                break;
            case STAFF:
                sql = "DELETE FROM staffers WHERE id = ?";
                break;
        }

        preparedStatement = Connect.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, user.getID());
        return preparedStatement.execute();
    }

    public boolean updateStaff(Staff staff) throws SQLException {

        preparedStatement = Connect.getConnection().prepareStatement(
                "UPDATE staffers SET username = ?, password = ?, firstname = ?, lastname = ? WHERE id = ?");

        setUser(preparedStatement, staff);

        return preparedStatement.execute();
    }

    public boolean updateTeacher(Teacher teacher) throws SQLException {
        preparedStatement = Connect.getConnection().prepareStatement("UPDATE teachers SET username = ?, password = ?, " +
                "firstname = ?, lastname = ?, subjectID = ? WHERE id = ?");

        setUser(preparedStatement, teacher);
        preparedStatement.setInt(5, teacher.getSubject().getID());

        return preparedStatement.execute();
    }

    public boolean updateStudent(Student student) throws SQLException {

        preparedStatement = Connect.getConnection().prepareStatement("UPDATE students SET username = ?, " +
                "password = ?, firstname = ?, lastname = ?, classID = ? WHERE id = ?");

        setUser(preparedStatement, student);
        preparedStatement.setInt(5, student.getSchoolClass().getClassID());

        return preparedStatement.execute();
    }
}
