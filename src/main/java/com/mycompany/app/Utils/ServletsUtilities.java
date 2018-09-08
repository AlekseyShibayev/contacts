package com.mycompany.app.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.app.Beans.Contact;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ServletsUtilities {

    public static void myResponsePrint(Contact contact, HttpServletResponse response){
        if (contact != null && response != null) {
            OutputStream outStream = null;
            try {
                outStream = response.getOutputStream();
                outStream.write(contact.toJson().getBytes("UTF-8"));
                outStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outStream != null) {
                    try {
                        outStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void myResponsePrint(List<Contact> contacts, HttpServletResponse response){
        if (contacts != null && response != null) {
            OutputStream outStream = null;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String arrayToJson = objectMapper.writeValueAsString(contacts);
                outStream = response.getOutputStream();
                outStream.write(arrayToJson.getBytes("UTF-8"));
                outStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if (outStream != null) {
                    try {
                        outStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void myResponsePrint(String string, HttpServletResponse response){
        if (string != null && response != null) {
            OutputStream outStream = null;
            try {
                outStream = response.getOutputStream();
                outStream.write(string.getBytes("UTF-8"));
                outStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outStream != null) {
                    try {
                        outStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void myResponsePrint(HttpServletResponse response){
        if (response != null) {
            OutputStream outStream = null;
            try {
                outStream = response.getOutputStream();
                outStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outStream != null) {
                    try {
                        outStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static boolean isContactCorrect (Contact contact) {
        if (contact != null && contact.getTelephone() != null && contact.getName() != null) {
            if (contact.getTelephone().length() >= 3 && contact.getTelephone().length() <= 100)  {
                if ((contact.getTelephone().matches("[0-9]{11}")) && (contact.getName().matches("[A-Za-zА-Яа-я0-9]*"))) {
                    return true;
                }}}
        return false;
    }

}





