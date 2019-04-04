package it.emes.schoolmanagement.server.request;

import it.emes.schoolmanagement.library.network.Request;
import it.emes.schoolmanagement.library.network.Response;
import it.emes.schoolmanagement.library.users.Staffer;
import it.emes.schoolmanagement.library.users.Student;
import it.emes.schoolmanagement.library.users.Teacher;
import it.emes.schoolmanagement.server.database.handler.Connect;
import it.emes.schoolmanagement.server.database.handler.SchoolHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetHandler implements Handler {

    @Override
    public Response handle(Request request) throws SQLException {

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        switch (request.getUserType()) {
            case STAFF:

                preparedStatement = Connect.getConnection().prepareStatement(
                        "SELECT id, username, password, firstname, lastname FROM staffers WHERE username = ?");
                preparedStatement.setString(1, request.getStaffer().getUsername());
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Staffer staffer = new Staffer(resultSet.getInt("id"), resultSet.getString("username"),
                            resultSet.getString("password"), resultSet.getString("firstname"),
                            resultSet.getString("lastname"));
                    return new Response(0, staffer);
                }
                return new Response(1);

            case TEACHER:

                preparedStatement = Connect.getConnection().prepareStatement(
                    "SELECT id, username, password, firstname, lastname, subjectID FROM teachers WHERE username = ?");
                preparedStatement.setString(1, request.getTeacher().getUsername());
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Teacher teacher = new Teacher(resultSet.getInt("id"), resultSet.getString("username"),
                            resultSet.getString("password"), resultSet.getString("firstname"),
                            resultSet.getString("lastname"),
                            SchoolHandler.getSchoolDAO().getSchool().getSubject(resultSet.getInt("subjectID")));
                    return new Response(0, teacher);
                }

                return new Response(1);

            case STUDENT:

                preparedStatement = Connect.getConnection().prepareStatement(
                        "SELECT id, username, password, firstname, lastname, classID FROM students WHERE username = ?");
                preparedStatement.setString(1, request.getStudent().getUsername());
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Student student = new Student(resultSet.getInt("id"), resultSet.getString("username"),
                            resultSet.getString("password"), resultSet.getString("firstname"),
                            resultSet.getString("lastname"),
                            SchoolHandler.getSchoolDAO().getSchool().getSchoolClass(resultSet.getInt("classID")));
                    return new Response(0, student);
                }
                return new Response(1);

                default:
                    System.out.println("Tipo utente sconosciuto: " + request.getUserType());
                    break;
        }
        return new Response(-1);
    }
}
