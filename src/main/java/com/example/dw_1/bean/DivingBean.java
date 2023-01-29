package com.example.dw_1.bean;

public class DivingBean implements Bean{
    private Integer divingId;
    private String divingName;
    private String divingManager;
    private String location;
    private String telephone;

    public DivingBean(){}
    public DivingBean(Integer id, String name, String manager, String city, String phone){
        this.divingId = id;
        this.divingName = name;
        this.divingManager = manager;
        this.location = city;
        this.telephone = phone;
    }

    public Integer getDivingId() {
        return divingId;
    }

    public void setDivingId(Integer divingId) {
        this.divingId = divingId;
    }

    public String getDivingName() {
        return divingName;
    }

    public void setDivingName(String divingName) {
        this.divingName = divingName;
    }

    public String getDivingManager() {
        return divingManager;
    }

    public void setDivingManager(String divingManager) {
        this.divingManager = divingManager;
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
