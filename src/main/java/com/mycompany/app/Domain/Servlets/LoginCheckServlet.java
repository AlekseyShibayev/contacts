package com.mycompany.app.Domain.Servlets;

import com.mycompany.app.Models.User;
import com.mycompany.app.Utils.JsonUtils;
import com.mycompany.app.Utils.ServletsUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginCheck.do")
public class LoginCheckServlet extends HttpServlet {

    final private static User goodUser = new User("test", "123");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonString = request.getParameter("entry");
        if (JsonUtils.isValidJson(jsonString)) {
            User checkUser = JsonUtils.getUserFromJson(jsonString);
            if (checkUser.equals(goodUser)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", 1);
                ServletsUtilities.myResponsePrint("1", response);
            }
        }
    }

}
