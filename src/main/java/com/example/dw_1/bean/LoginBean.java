package com.example.dw_1.bean;

public class LoginBean implements Bean{
    protected String userEmail;
    protected String userPassword;
    public LoginBean(String userEmail, String userPassword){
        setUserEmail(userEmail);
        setUserPassword(userPassword);
    }
    public String getUserEmail(){
        System.out.println(userEmail);
        return userEmail;
    }
    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        System.out.println(userPassword);
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
