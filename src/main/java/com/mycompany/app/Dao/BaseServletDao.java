package com.mycompany.app.Dao;

import javax.servlet.http.HttpServlet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseServletDao extends HttpServlet {

    Statement statement;

    @Override
    public void init() {
        try {
            System.out.println("statement opened");
            this.statement = ConnectionPostgresql.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        try {
            System.out.println("statement closed " + this.getClass());
            this.statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
