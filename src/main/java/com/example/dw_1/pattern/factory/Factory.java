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
    /* CORRETTO */
    public Regulator createRegulator(String idEquip,String divingID,String desc, Double price, String avail) {
        return new Regulator(idEquip,divingID,desc,price, avail);
    }
    public Mask createMask(String idEquip,String divingID,String desc, Double price, String avail) {
        return new Mask(idEquip,divingID,desc,price, avail);
    }
    /* CORRETTO */
    public Jacket createJack(String idEquip,String divingID,String desc, String size, String avail, Double price) {
        return new Jacket(idEquip,divingID,desc,size, avail, price);
    }
    /* CORRETTO */
    public Suit createSuit(String idEquip,String divingID,String desc, String size, String avail, Double price) {
        return new Suit(idEquip,divingID,desc,size, avail, price);
    }
    /* CORRETTO */
    public Finns createFinns(String idEquip,String divingID,String desc, String size, String avail, Double price) {
        return new Finns(idEquip,divingID,desc,size, avail, price);
    }


}
