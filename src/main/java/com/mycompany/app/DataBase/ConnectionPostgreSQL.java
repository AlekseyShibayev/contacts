package com.mycompany.app.DataBase;

import org.apache.log4j.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPostgreSQL {
    
    private Logger logger = LogManager.getLogger(ConnectionPostgreSQL.class);
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
            logger.debug("Connection created:");
        } catch (Exception e) {
            logger.debug("Can't connect to DB");
            e.printStackTrace();
        }
    }

}
