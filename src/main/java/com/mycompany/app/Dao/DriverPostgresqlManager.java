package com.mycompany.app.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverPostgresqlManager {

    final static String URL = "jdbc:postgresql://localhost:5432/java_db";
    final static String USER = "test";
    final static String PASS =  "123";

    public static Connection getPostgresqlConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }

}
