package it.emes.schoolmanagement.server.request;

import it.emes.schoolmanagement.library.network.Request;
import it.emes.schoolmanagement.library.network.Response;
import it.emes.schoolmanagement.library.users.Staffer;
import it.emes.schoolmanagement.library.users.User;
import it.emes.schoolmanagement.library.users.UserType;
import it.emes.schoolmanagement.server.database.dao.SchoolDAO;
import it.emes.schoolmanagement.server.database.handler.SchoolHandler;

import java.util.List;

public class LoginHandler implements Handler {

    private int ID;

    @Override
    public Response handle(Request request) {

        List<? extends User> list = null;
        SchoolHandler.getSchoolDAO().load();

        switch (request.getUserType()) {
            case STAFF:
                list = SchoolHandler.getSchoolDAO().getSchool().getStaffers();
                break;
            case TEACHER:
                list = SchoolHandler.getSchoolDAO().getSchool().getTeachers();
                break;
            case STUDENT:
                list = SchoolHandler.getSchoolDAO().getSchool().getStudents();
                break;
                default:
                    System.out.println("Tipo utente sconosciuto.. " + request.getUserType());
                    break;
        }

        return new Response(login(list, request.getUser()), getUser(request.getUserType()));
    }

    private int login(List<? extends User> list, User user) {
        int rs = -1;
        for (User us : list) {
            if (us.getUsername().equals(user.getUsername()) && us.getPassword().equals(user.getPassword())) {
                ID = us.getID();
                rs = 0;
            }
        }
        return rs;
    }

    private User getUser(UserType userType) {
        switch (userType) {
            case STAFF:
                return SchoolHandler.getSchoolDAO().getSchool().getStaffer(ID);
            case TEACHER:
                return SchoolHandler.getSchoolDAO().getSchool().getTeacher(ID);
            case STUDENT:
                return SchoolHandler.getSchoolDAO().getSchool().getStudent(ID);
                default:
                    System.out.println("Tipo utente sconosciuto: " + userType);
                    return null;
        }
    }
}
