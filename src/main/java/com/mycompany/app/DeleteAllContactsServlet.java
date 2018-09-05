package com.mycompany.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DeleteAllContactsServlet")
public class DeleteAllContactsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType ("text/html;charset=utf-8");
        String url = "jdbc:postgresql://localhost:5432/java_db";
        String user = "test";
        String pass =  "123";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM contacts;");
            Utilities.myResponsePrint(response);
        } catch (SQLException e) {
            Utilities.myResponsePrint("2", response);
            e.printStackTrace();
        }
    }
}
