package com.mycompany.app.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPostgreSQL {

    private static Connection connection;
    private final static String URL = "jdbc:postgresql://localhost:5432/java_db";
    private final static String USER = "test";
    private final static String PASS =  "123";

    public ConnectionPostgreSQL() {
    }

    public static Connection getConnection() {
        return connection;
    }

    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPostgreSQL.connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
