package it.emes.schoolmanagement.server.request;

import it.emes.schoolmanagement.library.network.Request;
import it.emes.schoolmanagement.library.network.Response;
import it.emes.schoolmanagement.library.school.School;
import it.emes.schoolmanagement.server.database.handler.SchoolHandler;

public class LoadHandler implements Handler {

    @Override
    public Response handle(Request request) {
        int rs = SchoolHandler.getSchoolDAO().load();
        return new Response(rs, new School(SchoolHandler.getSchoolDAO().getSchool()));
    }
}
