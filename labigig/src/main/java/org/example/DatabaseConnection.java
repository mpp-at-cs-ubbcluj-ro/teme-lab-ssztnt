// DatabaseConnection.java
package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:identifier.sqlite";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}