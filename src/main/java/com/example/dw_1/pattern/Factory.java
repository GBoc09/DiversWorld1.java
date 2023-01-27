package com.example.dw_1.pattern;

import com.example.dw_1.entity.Free;
import com.example.dw_1.entity.Manager;
import com.example.dw_1.entity.Scuba;
import com.example.dw_1.entity.User;

public class Factory {
    public User createScuba(String email, String pass, String name, String lastname,String license) {
        System.out.println("FACTORY");
        System.out.println(email);
        System.out.println(pass);
        System.out.println(name);
        System.out.println(lastname);
        System.out.println(license);
        return new Scuba(email, pass, name, lastname, license);
    }
    public User createFree(String email, String pass, String name, String lastname,String license) {
        return new Free(email, pass, name, lastname, license);
    }
    public User createManager(String name, String lastname, String email, String pass, String license) {
        return new Manager(email, pass, name, lastname, license);
    }


}
