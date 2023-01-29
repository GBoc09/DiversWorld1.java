package com.example.dw_1.entity;

public class Scuba extends User{
/* non prende niente */
    public Scuba(String email, String password, String name, String lastname, String license){
        super(email,password,name, lastname, license);
    }
    public Scuba () {
        super();
    }
    public Scuba(String uName, String uLast){
        super(uName,uLast);
    }
}
