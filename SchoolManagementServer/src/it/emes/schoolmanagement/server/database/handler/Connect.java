package it.emes.schoolmanagement.server.database.handler;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private static File file = new File("database");
    private static final String DB_PATH = "jdbc:sqlite:database/emesschool.db";
    private static Connection connection = null;

    private Connect() {}

    public static Connection getConnection() throws SQLException {
        file.mkdir();
        if (connection == null)
            connection = DriverManager.getConnection(DB_PATH);
        return connection;
    }
}
