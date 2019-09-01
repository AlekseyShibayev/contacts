package com.mycompany.app.Dao;

import com.mycompany.app.Models.Contact;
import org.hibernate.*;
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
    public Contact read(Integer id) {
        try (final Session session = factory.openSession()) {
            Contact result = session.get(Contact.class, id);
            if (result != null) {
                Hibernate.initialize(result.getCompany());
            }
            return result;
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
