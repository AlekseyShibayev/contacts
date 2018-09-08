package com.mycompany.app.Utils;

import com.mycompany.app.Beans.User;
import org.junit.Assert;
import org.junit.Test;

public class JsonUtilsTest {

    @Test
    public void test_isValidJson_true() {
        String json = "{\"login\":\"test\",\"password\":\"123\"}";
        Assert.assertTrue(JsonUtils.isValidJson(json));
    }

    @Test
    public void test_isValidJson_null() {
        String json = null;
        Assert.assertFalse(JsonUtils.isValidJson(json));
    }

    @Test
    public void test_isValidJson_false() {
        String json = "{login:\"test\",password:\"123\"}";
        Assert.assertFalse(JsonUtils.isValidJson(json));
    }

    @Test
    public void test_getUserFromJson() {
        String json = "{\"login\":\"test\",\"password\":\"123\"}";
        User user = new User("test", "123");
        User userJson = JsonUtils.getUserFromJson(json);
        Assert.assertEquals(user, userJson);
    }

}