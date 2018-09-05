package com.mycompany.app.Beans;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Contact implements Comparable<Contact> {

    private String telephone;
    private String name;

    Contact(){}

    public Contact(String telephone, String name) {
        this.telephone = telephone;
        this.name = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "telephone= " + this.getTelephone() + " name= " + this.getName();
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public int compareTo(Contact other) {
        if (other != null){
            if (this.getClass().equals(other.getClass())) {
                return (this.getName().compareTo(other.getName()));}
        }
        return 0;
    }

}


