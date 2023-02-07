package com.example.dw_1.bean;
public class UserBean implements Bean{
    private String name;
    private String lastname;
    private String userEmail;
    private String password;
    private Integer userType;
    private String license;
    public UserBean(){}
    public UserBean(String userEmail, String password,String name, String lastname, String license){
        setUserEmail(userEmail);
        setPassword(password);
        setName(name);
        setLastname(lastname);
        setLicense(license);
    }
    public UserBean(String userEmail,String name, String lastname, String license){
        setUserEmail(userEmail);
        setName(name);
        setLastname(lastname);
        setLicense(license);
    }
    public UserBean (String userEmail){
        setUserEmail(userEmail);
    }
    public UserBean(String userEmail, Integer userType){
        setUserEmail(userEmail);
        setUserType(userType);
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getPassword() {
        return password;
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
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

}
