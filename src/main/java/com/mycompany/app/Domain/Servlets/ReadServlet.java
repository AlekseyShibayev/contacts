package com.mycompany.app.Domain.Servlets;

import com.mycompany.app.Dao.ContactDao;
import com.mycompany.app.Dao.ContactDaoImpl;
import com.mycompany.app.Models.Contact;
import com.mycompany.app.Utils.ServletsUtilities;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/selectAll.do")
public class ReadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactDao contactDao = new ContactDaoImpl();
        Contact contact = contactDao.read(1);
        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact);
        ServletsUtilities.myResponsePrint(contacts, response);
    }

}