package com.mycompany.app.Servlets;

import com.mycompany.app.Dao.DriverPostgresqlManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class BaseServletController extends HttpServlet {
    DriverPostgresqlManager driver;

    @Override
    public void init() throws ServletException {
        ApplicationContext apcon = new ClassPathXmlApplicationContext("config.xml");
        DriverPostgresqlManager driver = (DriverPostgresqlManager) apcon.getBean("psql");
        this.driver = driver;
    }
    
}
