package com.example.dw_1.bean;

import java.util.Date;

public class UserBean implements Bean{
    private String name;
    private String lastname;
    private String email;
    private Integer license;
    private Date birthDate;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Integer getLicense() {
        return license;
    }

    public void setLicense(Integer license) {
        this.license = license;
    }

    public String getUserID(){
        return this.email;
    }
    public void setUserID (String email){
        this.email = email;
    }

    public String getName(){
        return this.name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLastname(){
        return this.lastname;
    }

    public void setName(String name) {
        this.name = name;
    }
}
