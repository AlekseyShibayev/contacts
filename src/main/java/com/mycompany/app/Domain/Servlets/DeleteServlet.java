package com.mycompany.app.Domain.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteAll.do")
public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            statement.executeUpdate("DELETE FROM contacts;");
//            ServletsUtilities.myResponsePrint(response);
//        } catch (SQLException e) {
//            ServletsUtilities.myResponsePrint("2", response);
//            e.printStackTrace();
//        }
    }

}
