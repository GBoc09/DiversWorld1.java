package com.example.dw_1.entity;

public class Diving {
    private String name;
    private String location;
    private String telephone;

    public Diving (String name, String location, String telephone){
        this.name = name;
        this.location = location;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
