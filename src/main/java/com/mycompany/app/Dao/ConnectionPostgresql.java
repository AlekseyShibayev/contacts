package com.mycompany.app.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPostgresql {

    private static Connection connection;
    private final static String URL = "jdbc:postgresql://localhost:5432/java_db";
    private final static String USER = "test";
    private final static String PASS =  "123";

    public ConnectionPostgresql() {
    }

    public static Connection getConnection() {
        System.out.println("im getConn DPM");
        return connection;
    }

    public void init() {
        System.out.println("im init Connection Postgresql");
        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPostgresql.connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return connection;
    }

}
