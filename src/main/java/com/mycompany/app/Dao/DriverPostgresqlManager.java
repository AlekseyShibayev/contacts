package com.mycompany.app.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverPostgresqlManager {

    public DriverPostgresqlManager() {
        System.out.println("im constructor DPM");
    }

    public Connection getConnection() {
        System.out.println("im getConn DPM");
        return connection;
    }

    public void setConnection(Connection connection) {
        System.out.println("im setConn DPM");
        this.connection = connection;
    }

    private Connection connection;
    private final static String URL = "jdbc:postgresql://localhost:5432/java_db";
    private final static String USER = "test";
    private final static String PASS =  "123";

    public void init() throws SQLException {
        System.out.println("im init DPM");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.connection = DriverManager.getConnection(URL, USER, PASS);
    }

}
