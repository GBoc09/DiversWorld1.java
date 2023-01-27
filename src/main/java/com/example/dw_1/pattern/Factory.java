package com.example.dw_1.pattern;

import com.example.dw_1.entity.Free;
import com.example.dw_1.entity.Manager;
import com.example.dw_1.entity.Scuba;
import com.example.dw_1.entity.User;

public class Factory {
    public User createScuba(String name, String lastname, String email, String pass, String license) {
        return new Scuba(name, lastname, email, pass, license);
    }
    public User createFree(String name, String lastname, String email, String pass, String license) {
        return new Free(name, lastname, email, pass, license);
    }
    public User createManager(String name, String lastname, String email, String pass, String license) {
        return new Manager(name, lastname, email, pass, license);
    }


}
