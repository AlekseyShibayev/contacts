package com.mycompany.app.Utils;

import com.mycompany.app.Beans.Contact;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class ServletsUtilitiesTest {
    static final List<Contact> list = new ArrayList<>();
    @BeforeClass
    public static void init(){
        list.add(new Contact(null, null));
        list.add(new Contact("01", "A"));
        list.add(new Contact("01", "B"));
        list.add(new Contact("79788615101", "Aleksey"));
        list.add(new Contact("79788615101", "!@!#~!@"));
    }

    @Before
    public void setup() {}

    @Test
    public void test_isContactCorrect_0() {
        Assert.assertFalse(ServletsUtilities.isContactCorrect(list.get(0)));
    }

    @Test
    public void test_isContactCorrect_1() {
        Assert.assertFalse(ServletsUtilities.isContactCorrect(list.get(1)));
    }

    @Test
    public void test_isContactCorrect_2() {
        Assert.assertFalse(ServletsUtilities.isContactCorrect(list.get(2)));
    }

    @Test
    public void test_isContactCorrect_3() {
        Assert.assertTrue(ServletsUtilities.isContactCorrect(list.get(3)));
    }

    @Test
    public void test_isContactCorrect_4() {
        Assert.assertFalse(ServletsUtilities.isContactCorrect(list.get(4)));
    }

}