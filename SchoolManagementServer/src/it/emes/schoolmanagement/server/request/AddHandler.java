package it.emes.schoolmanagement.server.request;

import it.emes.schoolmanagement.library.network.Request;
import it.emes.schoolmanagement.library.network.Response;
import it.emes.schoolmanagement.library.users.User;
import it.emes.schoolmanagement.server.database.dao.StafferDAO;
import it.emes.schoolmanagement.server.database.handler.SchoolHandler;

import java.util.List;

public class AddHandler implements Handler {

    List<? extends User> list = null;

    @Override
    public Response handle(Request request) {
        int res = -1;
        switch (request.getUserType()) {
            case STAFF:
                res = new StafferDAO().addStaffer(request.getStaffer());
                break;
            case TEACHER:
                res = new StafferDAO().addTeacher(request.getTeacher());
                break;
            case STUDENT:
                res = new StafferDAO().addStudent(request.getStudent());
                break;
                default:
                    System.out.println("Tipo utente sconosciuto: " + request.getUserType());
                    break;
        }
        SchoolHandler.getSchoolDAO().load();
        return new Response(res, SchoolHandler.getSchoolDAO().getSchool());
    }

}
