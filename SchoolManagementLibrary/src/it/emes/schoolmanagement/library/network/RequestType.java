package it.emes.schoolmanagement.library.network;

import java.io.Serializable;

public enum RequestType implements Serializable {

    LOGIN,
    LOAD,
    ADD_USER,
    GET_USER,
    DELETE_USER,
    UPDATE_USER;

}
