package com.mycompany.app.Beans;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class ContactTest {

    static List<Contact> listContacts = new ArrayList<>();

    @BeforeClass
    public static void init(){
        listContacts.add(new Contact(null, null));
        listContacts.add(new Contact(null, null));
        listContacts.add(new Contact("01", "A"));
        listContacts.add(new Contact("01", "B"));
    }

    @Before
    public void setup() {}

    @Test
    public void test_compareTo_null_null() {
        Assert.assertTrue( listContacts.get(1).compareTo(listContacts.get(0)) == 0);
    }

    @Test
    public void test_compareTo_name_A_name_B() {
        Assert.assertTrue( listContacts.get(3).compareTo(listContacts.get(2)) == 1);
    }

}