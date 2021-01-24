package com.example.JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String SERVER_ADDRESS = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "jackthesnack";
    
    private static DBConnection instance = null;
    
    private DBConnection() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }
    
    public Connection connection() throws SQLException {
        return DriverManager.getConnection(SERVER_ADDRESS, USERNAME, PASSWORD);
    }

    public static DBConnection instance() throws ClassNotFoundException {
        Class.forName(("org.postgresql.Driver"));
        if (instance == null) {
            instance = new DBConnection();
        }

        return instance;
    }
}