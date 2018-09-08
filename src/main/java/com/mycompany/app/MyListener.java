package com.mycompany.app;

import com.mycompany.app.Dao.ConnectionPostgresql;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextInitialized");
        ConnectionPostgresql connection = new ConnectionPostgresql();
        connection.init();
//        ApplicationContext apcon = new ClassPathXmlApplicationContext("config.xml");
//        ConnectionPostgresql driverPostgresqlManager = (ConnectionPostgresql) apcon.getBean("psql");
//        BaseServletDao driverPostgresqlManager.getConnection();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
