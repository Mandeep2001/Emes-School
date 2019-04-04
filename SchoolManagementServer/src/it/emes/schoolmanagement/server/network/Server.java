package it.emes.schoolmanagement.server.network;

import it.emes.schoolmanagement.server.database.handler.SchoolHandler;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private ServerSocket server;
    static SchoolHandler  schoolHandler = null;

    public Server() {
        try {
            server = new ServerSocket(9898);
            System.out.println("Server avviato.");
        } catch (IOException ex) {
            System.err.println("Errore durante l'avvio del server.. " + ex.getMessage());
        }

        while (server != null) {
            try {
                new ClientHandler(server.accept()).start();
                System.out.println("Server connesso.");
            } catch (IOException ex) {
                System.err.println("Errore durante la connessione ad un client: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SchoolHandler.getSchoolDAO().load();
        new Server();
    }
}
