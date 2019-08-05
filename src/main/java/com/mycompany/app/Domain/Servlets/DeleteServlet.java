package com.mycompany.app.Domain.Servlets;

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

@WebServlet(urlPatterns = "/deleteAll.do")
public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactDaoImpl contactDao = new ContactDaoImpl();
        contactDao.delete(1);
    }

}