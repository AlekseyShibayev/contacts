package com.mycompany.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.app.Beans.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "InsertContactsServlet")
public class InsertContactsServlet extends HttpServlet {

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
            ObjectMapper mapper = new ObjectMapper();
            Contact contact = mapper.readValue(request.getParameter("entry"), Contact.class);
            if ((contact.getTelephone().matches("[0-9]{11}")) && (contact.getName().matches("[A-Za-zА-Яа-я0-9]*"))) {
                ResultSet rs = statement.executeQuery("SELECT * FROM contacts WHERE telephone = '" + contact.getTelephone() + "';");
                if (!rs.isBeforeFirst()) {
                    statement.executeUpdate("INSERT INTO contacts (telephone, name) "
                            + "VALUES ('" + contact.getTelephone() + "', '" + contact.getName() + "');");
                    Utilities.myResponsePrint(contact, response);
                }
                else {
                    Utilities.myResponsePrint("0", response);
                }
            } else {
                Utilities.myResponsePrint("1", response);
            }
        } catch (SQLException e) {
            Utilities.myResponsePrint("2", response);
            e.printStackTrace();
        }
    }
}
