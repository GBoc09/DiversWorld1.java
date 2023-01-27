package com.example.dw_1.bean;

import com.example.dw_1.exception.InvalidCredentialException;

import java.util.Date;

public class UserBean implements Bean{
    private String name;
    private String lastname;
    private String userEmail;
    private String password;
    private Integer userType;
    private Integer license;
    public UserBean(){}
    public UserBean(String userEmail, Integer userType){
        setUserEmail(userEmail);
        setUserType(userType);
    }
    public UserBean(String userEmail){
        setUserEmail(userEmail);
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLicense() {
        return license;
    }

    public void setLicense(Integer license) {
        this.license = license;
    }

}
