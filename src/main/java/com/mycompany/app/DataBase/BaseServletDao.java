package com.mycompany.app.DataBase;

import javax.servlet.http.HttpServlet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseServletDao extends HttpServlet {

    Statement statement;

    @Override
    public void init() {
        System.out.println("init " + this.getClass());
        try {
            this.statement = ConnectionPostgreSQL.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy " + this.getClass());
        try {
            this.statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
