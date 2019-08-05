package com.mycompany.app.Dao;

import com.mycompany.app.Models.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ContactDaoImpl implements ContactDao {

    private final SessionFactory factory;

    public ContactDaoImpl() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void create(Contact model) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(model);
            session.getTransaction().commit();
        }
    }

    @Override
    public Contact read(Integer integer) {
        try (final Session session = factory.openSession()) {
            final Contact result = session.get(Contact.class, integer);
            return result != null ? result : new Contact();
        }
    }

    @Override
    public void update(Contact model) {
        //TODO
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(model);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Integer integer) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(session.get(Contact.class, integer));
            session.getTransaction().commit();
        }
    }

}
