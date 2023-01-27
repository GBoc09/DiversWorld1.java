package com.example.dw_1.entity;

import java.util.Date;

public class Scuba extends User{
    private String name;
    private String lastname;
    private Integer license;

    public Scuba(String email, String password, String name, String lastname, Integer license){
        super(email,password,name, lastname);
        setLicense(license);
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

    public Integer getLicense() {
        return license;
    }
    public void setLicense(Integer license) {
        this.license = license;
    }
}
