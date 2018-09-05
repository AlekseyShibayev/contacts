package com.mycompany.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.app.Beans.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(request.getParameter("entry"), User.class);
        if (user.getLogin().equals("test")&&(user.getPassword().equals("123"))) {
            HttpSession session = request.getSession();
            session.setAttribute("user", 1);
            Utilities.myResponsePrint("1", response);
        }
    }

}
