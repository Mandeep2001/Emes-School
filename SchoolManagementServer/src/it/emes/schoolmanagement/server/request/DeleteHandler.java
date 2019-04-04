package it.emes.schoolmanagement.server.request;

import it.emes.schoolmanagement.library.network.Request;
import it.emes.schoolmanagement.library.network.Response;
import it.emes.schoolmanagement.server.database.handler.Connect;
import it.emes.schoolmanagement.server.database.handler.SchoolHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteHandler implements Handler {

    @Override
    public Response handle(Request request) throws SQLException {

        String query = null;
        int ID = request.getUser().getID();

        switch (request.getUserType()) {
            case STAFF:
                query = "DELETE FROM staffers WHERE id = ?";
                break;
            case TEACHER:
                query = "DELETE FROM teachers WHERE id = ?";
                break;
            case STUDENT:
                query = "DELETE FROM students WHERE id = ?";
                break;
                default:
                    System.out.println("Tipo utente sconosciuto: " + request.getUserType());
                    return new Response(-1);
        }

        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, ID);

        preparedStatement.execute();
        SchoolHandler.getSchoolDAO().load();

        return new Response(0, SchoolHandler.getSchoolDAO().getSchool());
    }
}
