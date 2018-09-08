package com.mycompany.app.DataBase;

import com.mycompany.app.Beans.Contact;
import com.mycompany.app.Utils.ServletsUtilities;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "SelectContactsServlet")
public class SelectContactsServlet extends BaseServletDao {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM contacts;");
            if (!rs.isBeforeFirst()) {
                ServletsUtilities.myResponsePrint("1", response);
            } else {
                List<Contact> contacts = new ArrayList<>();
                while (rs.next()) {
                    Contact contact= new Contact(rs.getString("telephone"), rs.getString("name"));
                    contacts.add(contact);
                }
                Collections.sort(contacts);
                ServletsUtilities.myResponsePrint(contacts, response);
            }
        } catch (SQLException e) {
            ServletsUtilities.myResponsePrint("2", response);
            e.printStackTrace();
        }
    }

}