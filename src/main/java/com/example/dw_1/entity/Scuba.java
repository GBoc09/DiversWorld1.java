package com.example.dw_1.entity;

public class Scuba extends User{
    private String name;
    private String lastname;
    private String license;

    public Scuba(String email, String password, String name, String lastname, String license){
        super(email,password,name, lastname, license);
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

    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }
}
