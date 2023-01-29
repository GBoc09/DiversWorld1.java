package com.example.dw_1.entity;

public class Free extends User{
    public Free(String email, String password, String name, String lastname, String license){
        super(email,password,name, lastname, license);

    }
    public Free () {
        super();
    }
    public Free(String uName, String uLast){
        super(uName,uLast);
    }
}
