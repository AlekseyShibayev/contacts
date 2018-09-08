package com.mycompany.app.Dao;

import com.mycompany.app.Utilities;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DeleteAllContactsServlet")
public class DeleteAllContactsServlet extends BaseServletDao {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            statement.executeUpdate("DELETE FROM contacts;");
            Utilities.myResponsePrint(response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
