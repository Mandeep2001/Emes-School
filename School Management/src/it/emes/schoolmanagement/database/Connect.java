package it.emes.schoolmanagement.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe realizzata usando il Singleton Pattern, chiamando il metodo statico getConnection() restituisce la connessione
 * e essa &egrave; uguale a null ne crea una nuova e restituisce sempre la stessa.
 */

public class Connect {

    private static File file = new File("database");
    private final static String DB_PATH = "jdbc:sqlite:database/emesschool.db";
    private static Connection connection;

    /**
     * Costruttore privato per non far istanziare la classe.
     */
    private Connect() {}

    /**
     * Metodo statico che restituisce una nuova istanza di Connection se essa non è ancora stata istanziata, se invece esiste già un'istanza
     * restituisce sempre la stessa.
     * @return una connessione al database.
     */
    public static Connection getConnection() {
        file.mkdir();
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_PATH);
            } catch (SQLException ex) {
                System.err.println("Errore durante la connessione al database.. " + ex.getMessage());
            }
        }
        System.out.println("Connesso al database.");
        return connection;
    }
}
