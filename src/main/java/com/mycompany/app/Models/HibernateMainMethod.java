package com.mycompany.app.Models;

import com.mycompany.app.Dao.ContactDao;
import com.mycompany.app.Dao.ContactDaoImpl;

public class HibernateMainMethod {
    public static void main(String[] args) {
        ContactDao contactDao = new ContactDaoImpl();
        Contact contact = contactDao.read(1);
        System.out.println(contact);
    }
}
