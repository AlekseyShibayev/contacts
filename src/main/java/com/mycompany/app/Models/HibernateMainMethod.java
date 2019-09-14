package com.mycompany.app.Models;

import com.mycompany.app.Dao.*;

import java.util.HashSet;
import java.util.Set;

public class HibernateMainMethod {
    public static void main(String[] args) {
        //create test
        ContactDao contactDao = new ContactDaoImpl();

        Telephone telephone1 = Telephone.builder().number("01").build();
        Telephone telephone2 = Telephone.builder().number("02").build();
        Set<Telephone> telephoneSet = new HashSet<>();
        telephoneSet.add(telephone1);
        telephoneSet.add(telephone2);

        Company newCompany = Company.builder().name("EPAM").build();

        Device device1 = Device.builder().name("android").build();
        Device device2 = Device.builder().name("iphone").build();
        Set<Device> deviceSet = new HashSet<>();
        deviceSet.add(device1);
        deviceSet.add(device2);

        Contact newContact = Contact.builder()
                .name("Aleksey")
                .company(newCompany)
                .deviceSet(deviceSet)
                .telephoneSet(telephoneSet)
                .build();

        contactDao.create(newContact);
        int id = newContact.getId();
        System.out.println(id);
        //read test
        Contact contact = contactDao.read(id);
        System.out.println(contact);

        //update test
        Set<Telephone> telephones = contact.getTelephoneSet();
        telephones.add(Telephone.builder().number("03").build());
        contact.setTelephoneSet(telephones);
        contactDao.update(contact);
        System.out.println(contactDao.read(id));

        // delete test
        contactDao.delete(id);

        System.out.println("CRUD is work");
    }
}
