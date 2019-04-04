package it.emes.schoolmanagement.database.dao;

import it.emes.schoolmanagement.database.Connect;
import it.emes.schoolmanagement.serializable.school.Vote;
import it.emes.schoolmanagement.serializable.user.Student;
import it.emes.schoolmanagement.serializable.user.Teacher;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherDAO {

    public boolean addVote(Teacher teacher, Student student, double vote) throws SQLException {

        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement("INSERT INTO " +
                "votes (studentID, teacherID, studentID, vote) " +
                "VALUES (?, ?, ?, ?);");
        preparedStatement.setInt(1, student.getID());
        preparedStatement.setInt(2, teacher.getID());
        preparedStatement.setInt(3, teacher.getSubject().getID());
        preparedStatement.setDouble(4, vote);

        return preparedStatement.execute();
    }

    public boolean removeVote(Vote vote) throws SQLException {

        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement("DELETE FROM votes WHERE id = ?");
        preparedStatement.setInt(1, vote.getID());

        return preparedStatement.execute();
    }
}
