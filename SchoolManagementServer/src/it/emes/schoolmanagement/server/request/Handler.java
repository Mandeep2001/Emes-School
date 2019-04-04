package it.emes.schoolmanagement.server.request;

import it.emes.schoolmanagement.library.network.Request;
import it.emes.schoolmanagement.library.network.Response;

import java.sql.SQLException;

public interface Handler {

    Response handle(Request request) throws SQLException;

}
