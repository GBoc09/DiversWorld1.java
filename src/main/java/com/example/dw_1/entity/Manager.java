package com.example.dw_1.entity;

import java.util.Date;

public class Manager extends User{
    private String name;
    private String lastname;
    private Date birthDate;

    public Manager(String email, String password, String name, String lastname){
        super(email,password,name, lastname);
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
