package com.example.dw_1.bean;
public class RegistrationBean extends UserBean implements Bean{
    private String name;
    private String lastname;
    private String userEmail;
    private String password;
    private Integer userType;
    private String license;
    public RegistrationBean(){}
    public RegistrationBean(String userEmail, Integer userType){
        setUserEmail(userEmail);
        setUserType(userType);
    }
    public RegistrationBean(String userEmail){
        setUserEmail(userEmail);
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getLastname() {
        return lastname;
    }
    @Override
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String getUserEmail() {
        return userEmail;
    }
    @Override
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    @Override
    public Integer getUserType() {
        return userType;
    }
    @Override
    public void setUserType(Integer userType) {
        this.userType = userType;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String getLicense() {
        return license;
    }
    @Override
    public void setLicense(String license) {
        this.license = license;
    }

    public Boolean validateName (String name) {
        return isAlphabetic(name);
    }
    public Boolean validateLastname(String lastname) {
        return isAlphabetic(lastname);
    }
    public Boolean validateLicense(String license) {
        return isNumeric(license);
    }
    private Boolean isNumeric(String num){
        // brevetto solo numeri
        return num.matches("\\d");

    }

    private Boolean isAlphabetic(String word){
        // nome e cognome solo lettere
        return word.matches("[a-zA-Z]*");
    }

}
