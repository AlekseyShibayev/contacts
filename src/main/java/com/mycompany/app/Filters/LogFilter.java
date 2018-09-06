package com.mycompany.app.Filters;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "LogFilter")
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        long before = System.currentTimeMillis();
        chain.doFilter(req, resp);
        long after = System.currentTimeMillis();
        Logger logger = LogManager.getLogger(LogFilter.class);
        logger.debug(after-before + " ms:");
    }

    @Override
    public void destroy() {
    }

}
