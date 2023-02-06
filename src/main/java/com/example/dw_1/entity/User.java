package com.example.dw_1.entity;

public class User {
    private String email;
    private String password;
    private String name;
    private String lastname;
    private String license;
    public User(String email, String password, String name, String lastname, String license){
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.license = license;
    }
    /* protected */
    public User(){}
    public User (String name, String lastname, String license, String email){
        this.name = name;
        this.lastname = lastname;
        this.license = license;
        this.email = email;
    }
    public User(String uName, String uLast){
        this.name = uName;
        this.lastname = uLast;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return this.password;
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

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
