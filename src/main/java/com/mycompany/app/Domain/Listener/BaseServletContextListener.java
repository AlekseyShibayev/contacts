package com.mycompany.app.Domain.Listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class BaseServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
