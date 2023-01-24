package com.example.dw_1.entity;

import java.util.Date;

public class User {
    private String name;
    private String lastname;
    private Date birthDate;
    private Integer license;
    private String email;
    private String password;
    public User(String email, String name, String lastname, String password, Integer license){
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.license = license;
    }
    public User(){}

    public String getEmail(){
        return this.email;
    }
    public String getName(){
        return this.name;
    }
    public String getLastname(){
        return this.lastname;
    }
    public Date getBirthDate() {
        return this.birthDate;
    }
    public String getPassword(){
        return this.password;
    }
    public Integer getLicense() {
        return license;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setLicense(Integer license) {
        this.license = license;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
