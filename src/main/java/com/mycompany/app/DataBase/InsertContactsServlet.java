package com.mycompany.app.DataBase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.app.Beans.Contact;
import com.mycompany.app.Utils.JsonUtils;
import com.mycompany.app.Utils.ServletsUtilities;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "InsertContactsServlet")
public class InsertContactsServlet extends BaseServletDao {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String jsonString = request.getParameter("entry");
            if (JsonUtils.isValidJson(jsonString)) {
                Contact contact = JsonUtils.getContactFromJson(jsonString);
                if (ServletsUtilities.isContactCorrect(contact)) {
                    ResultSet rs = statement.executeQuery("SELECT * FROM contacts WHERE telephone = '" + contact.getTelephone() + "';");
                    if (!rs.isBeforeFirst()) {
                        statement.executeUpdate("INSERT INTO contacts (telephone, name) "
                                + "VALUES ('" + contact.getTelephone() + "', '" + contact.getName() + "');");
                        ServletsUtilities.myResponsePrint(contact, response);
                    }
                    else {
                        ServletsUtilities.myResponsePrint("0", response);
                    }
                } else {
                    ServletsUtilities.myResponsePrint("1", response);
                }
            }
        }catch (SQLException e) {
            ServletsUtilities.myResponsePrint("2", response);
            e.printStackTrace();
        }
    }

}
