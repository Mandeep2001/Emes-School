package it.emes.schoolmanagement.database.dao;

import it.emes.schoolmanagement.database.Connect;
import it.emes.schoolmanagement.serializable.school.Vote;
import it.emes.schoolmanagement.serializable.user.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private PreparedStatement preparedStatement;

    public List<Vote> getVotes(Student student) throws SQLException {
        List<Vote> votes = new ArrayList<>();
        preparedStatement = Connect.getConnection().prepareStatement("SELECT FROM votes WHERE studentID = ?");
        preparedStatement.setInt(1, student.getID());

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            votes.add(new Vote(rs.getInt("id"),rs.getInt("studentID"), rs.getInt("teacehrID"),
                    rs.getInt("subjectID"), rs.getDouble("vote")));
        }

        return votes;
    }
}
