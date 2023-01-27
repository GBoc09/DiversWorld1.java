package com.example.dw_1.entity;

import java.time.LocalDate;

public class User {
    private String email;
    private String password;
    private String name;
    private String lastname;
    private Integer license;
    public User(String email, String password, String name, String lastname){
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
    }
    public User(){}

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
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
