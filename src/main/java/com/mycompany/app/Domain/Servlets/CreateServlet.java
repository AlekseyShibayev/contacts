package com.mycompany.app.Domain.Servlets;

import com.mycompany.app.Dao.ContactDao;
import com.mycompany.app.Dao.ContactDaoImpl;
import com.mycompany.app.Models.Contact;
import com.mycompany.app.Utils.JsonUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/insert.do")
public class CreateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonString = request.getParameter("entry");
        if (JsonUtils.isValidJson(jsonString)) {
            Contact contact = JsonUtils.getContactFromJson(jsonString);
            ContactDao contactDao = new ContactDaoImpl();
            contactDao.create(contact);
        }
    }

}
