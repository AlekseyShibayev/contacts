package com.mycompany.app.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class SecurityFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setContentType ("text/html;charset=utf-8");
        String url = request.getRequestURI();
        if (url.endsWith(".do")) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect("/home.do");
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

}
