package com.example.dw_1.entity;

public class Scuba extends User{
    private String name;
    private String lastname;
    private String license;
/* non prende niente */
    public Scuba(String email, String password, String name, String lastname, String license){
        super(email,password,name, lastname, license);
    }
    public String getName() {
        System.out.println("SCUBA");
        System.out.println(name);
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        System.out.println(lastname);
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLicense() {
        System.out.println(license);
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }
}
