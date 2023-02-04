package com.example.dw_1.entity;

public class Diving {
    private String divingID;
    private String name;
    private String divingMan;
    private String location;
    private String telephone;

    public Diving (String id, String name, String location, String telephone){
        this.divingID = id;
        this.name = name;
        this.location = location;
        this.telephone = telephone;
    }
    public Diving (String id, String name, String divingMan, String location, String telephone){
        this.divingID = id;
        this.name = name;
        this.divingMan = divingMan;
        this.location = location;
        this.telephone = telephone;
    }

    public Diving(String name, String location){
        this.name = name;
        this.location = location;
    }

    public String getDivingID() {
        return divingID;
    }

    public void setDivingID(String divingID) {
        this.divingID = divingID;
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

    public String getDivingMan() {
        return divingMan;
    }

    public void setDivingMan(String divingMan) {
        this.divingMan = divingMan;
    }
}
