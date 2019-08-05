package com.mycompany.app.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.app.Models.Contact;
import com.mycompany.app.Models.User;
import java.io.IOException;

public class JsonUtils {

    public static boolean isValidJson (String json) {
        boolean valid = false;
        if (json != null) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.readTree(json);
                valid = true;
            } catch(Exception e){
                return false;
            }
        }
        return valid;
    }

    public static User getUserFromJson(String json) {
        User user = null;
        try {
            user = new ObjectMapper().readValue(json, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static Contact getContactFromJson(String json) {
        Contact contact = null;
        try {
            contact = new ObjectMapper().readValue(json, Contact.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contact;
    }

}
