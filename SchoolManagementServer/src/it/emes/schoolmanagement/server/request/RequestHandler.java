package it.emes.schoolmanagement.server.request;

import it.emes.schoolmanagement.library.network.Request;
import it.emes.schoolmanagement.library.network.Response;

import java.sql.SQLException;

public class RequestHandler {

    private RequestFactory requestFactory;

    public RequestHandler() {
        requestFactory = new RequestFactory();
    }

    public Response handle(Request request) {
        Handler handler = requestFactory.getHandler(request.getRequestType());
        try {
            return handler.handle(request);
        } catch (SQLException ex) {
            System.err.println("Errore dutante la gestione della richiesta.. " + ex.getMessage());
            return null;
        }
    }
}
