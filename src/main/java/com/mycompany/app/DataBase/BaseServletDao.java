package com.mycompany.app.DataBase;

import javax.servlet.http.HttpServlet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseServletDao extends HttpServlet {

    Statement statement;

    @Override
    public void init() {
        try {
            this.statement = ConnectionPostgreSQL.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        try {
            this.statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
