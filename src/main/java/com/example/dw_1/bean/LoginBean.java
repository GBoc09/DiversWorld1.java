package com.example.dw_1.bean;

public class LoginBean implements Bean{
    protected String userEmail;
    protected String userPassword;
    public LoginBean(String userEmail, String userPassword){
        setUserEmail(userEmail);
        setUserPassword(userPassword);
    }
    public String getUserEmail(){
        return userEmail;
    }
    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
