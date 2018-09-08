package com.mycompany.app.Views;

import org.junit.Test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class MainViewTest {

    private static final String path = "/index.jsp";

    @Test
    public void test_MainView_doGet() throws ServletException, IOException {
        final MainView mainView = new MainView();
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(path)).thenReturn(requestDispatcher);
        mainView.doGet(request, response);
        verify(request, times(1)).getRequestDispatcher(path);
        verify(request, never()).getSession();
        verify(requestDispatcher).forward(request, response);
    }

}