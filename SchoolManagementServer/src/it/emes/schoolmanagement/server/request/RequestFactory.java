package it.emes.schoolmanagement.server.request;

import it.emes.schoolmanagement.library.network.RequestType;

public class RequestFactory {

    public Handler getHandler(RequestType requestType) {
        switch (requestType) {
            case LOAD:
                return new LoadHandler();
            case LOGIN:
                return new LoginHandler();
            case ADD_USER:
                return new AddHandler();
            case GET_USER:
                return new GetHandler();
            case DELETE_USER:
                return new DeleteHandler();
            case UPDATE_USER:
                break;
        }
        return null;
    }

}
