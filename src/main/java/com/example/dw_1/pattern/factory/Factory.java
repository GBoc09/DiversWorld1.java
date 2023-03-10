package com.example.dw_1.pattern.factory;

import com.example.dw_1.entity.*;

public class Factory {
    public User createScuba(String email, String pass, String name, String lastname,String license) {
        return new Scuba(email, pass, name, lastname, license);
    }
    public User createFree(String email, String pass, String name, String lastname,String license) {
        return new Free(email, pass, name, lastname, license);
    }
    public User createManager(String email, String pass, String name, String lastname,String license) {
        return new Manager(email, pass, name, lastname, license);
    }
    public Diving createDiving(String id, String name, String divngMan, String loc, String tel) {
        return new Diving(id, name, divngMan, loc, tel);
    }
    public Equipment createEquip(String idE, String idD, String typeE, String size, String avail, Double price) {
        return new Equipment(idE, idD, typeE, size, avail, price);
    }


}
