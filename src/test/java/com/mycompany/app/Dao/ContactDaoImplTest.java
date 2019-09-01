package com.mycompany.app.Dao;

import com.mycompany.app.Models.Contact;
import org.junit.*;

import static org.junit.Assert.*;


public class ContactDaoImplTest {

    @Test
    public void whenReadContactThen () {
        ContactDao contactDao = new ContactDaoImpl();
        Contact contact = contactDao.read(1);
        assertEquals(2, contact.getTelephoneSet().size());
    }

}
