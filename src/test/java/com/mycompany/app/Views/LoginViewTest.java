package com.mycompany.app.Views;

import org.junit.Test;
import static org.mockito.Mockito.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginViewTest {

    private static final String path = "/login.jsp";

    @Test
    public void test_LoginView_doGet() throws ServletException, IOException {
        final LoginView loginView = new LoginView();
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(path)).thenReturn(requestDispatcher);
        loginView.doGet(request, response);
        verify(request, times(1)).getRequestDispatcher(path);
        verify(request, never()).getSession();
        verify(requestDispatcher).forward(request, response);
    }

}