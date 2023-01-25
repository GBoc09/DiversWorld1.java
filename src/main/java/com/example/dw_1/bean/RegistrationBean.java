package com.example.dw_1.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class RegistrationBean implements Bean{
    private String name;
    private String lastname;
    private String license;
    private String email;
    private String password;
    //private LocalDate birthDate;

    public String getName() {
        return this.name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email.toLowerCase();
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   /* public LocalDate getBirthDate() {
        return birthDate;
    }*/

   /* public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }*/

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

    /*public Boolean validatePassword(String password) {
        // password inserite rispettano i paraemtri della piattaforma.
        boolean flag = false;
        // rispetto il range di lunghezza entro cui deve stare la password
        if (password.length() < ProfileManagementGraphicControl.getMinPassLenght() &&
                password.length() > ProfileManagementGraphicControl.getMaxPassLenght()) {
            return false;
        }
        // verifico che non ci siano caratteri che il mio sistema non ammette
        for (Character forbidden : ProfileManagementGraphicControl.getForbiddenChar()) {
            if (password.contains(forbidden.toString())) {
                return false;
            }
        }
        // verifico che ci siano solo caretteri ammessi dal sistema
        for (String allowed : ProfileManagementGraphicControl.getAllowedChar()) {
            for(int i = 0; i<allowed.length(); i++) {
                if(password.contains(Character.toString(allowed.charAt(i)))){
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                return false;
            }
            flag = false;
        }
        return true;
    }*/
    public Boolean validateEmail(String email){
        // verifico il formato di formattazione dell'email
        return email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    }
}
