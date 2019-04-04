package it.emes.schoolmanagement.client.network;

import it.emes.schoolmanagement.library.network.Request;
import it.emes.schoolmanagement.library.network.Response;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RequestService extends Service<Response> {

    private Request request;
    private Response response;
    private Socket server;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    /**
     * Costruttore della classe RequestService, permette di creare un nuovo thread che invia una richiesta e
     * riceve una risposta dal server.
     * @param request Richiesta da inviare al server.
     */
    public RequestService(Request request) {
        try {
            this.request = request;
            server = new Socket(Util.IP_ADRESS, Util.PORT);
        } catch (IOException ex) {
            System.err.println("Errore durante la connessione al server.. " + ex.getMessage());
        }
    }

    /**
     * Metodo che parte quando viene istanziata questa classe, invia la richiesta al server e ne riceve la risposta
     * @return Risposta del server
     */
    @Override
    protected Task<Response> createTask() {
        return new Task<Response>() {
            @Override
            protected Response call() throws Exception {
                try {
                    out = new ObjectOutputStream(server.getOutputStream());
                    in = new ObjectInputStream(server.getInputStream());
                    out.writeObject(request);
                    response = (Response) in.readObject();
                    return response;
                } catch (Exception ex) {
                    System.err.println("Errore nell'invio della richiesta.. " + ex.getMessage());
                    return null;
                }
            }
        };
    }
}
