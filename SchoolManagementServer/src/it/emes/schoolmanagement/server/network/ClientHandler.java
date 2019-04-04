package it.emes.schoolmanagement.server.network;

import it.emes.schoolmanagement.library.network.Request;
import it.emes.schoolmanagement.library.network.Response;
import it.emes.schoolmanagement.server.request.RequestHandler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread{

    private Socket client;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    private RequestHandler requestHandler;

    private ClientHandler() {}

    public ClientHandler(Socket client) {
        requestHandler = new RequestHandler();
        this.client = client;
    }

    @Override
    public void run() {
        try {
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());

            Request request = (Request) in.readObject();
            System.out.println("Richiesta ricevuta: " + request);
            Response response = requestHandler.handle(request);
            out.writeObject(response);
            System.out.println("Risposta inviata: " + response);

        } catch (Exception ex) {
            System.err.println("Errore durante la gestione del client.. " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
