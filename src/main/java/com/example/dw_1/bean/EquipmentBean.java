package com.example.dw_1.bean;

public class EquipmentBean implements Bean {
    private String idBean;
    private Integer equipType;
    private String sizeBean;
    private String availBean;
    private String descrBean;
    private Double priceBean;
    private String divingID;

    public EquipmentBean (String id, Integer type, String size, String avail, String desc, Double price, String divID){
        this.idBean = id;
        this.equipType = type;
        this.sizeBean = size;
        this.availBean = avail;
        this.descrBean = desc;
        this.priceBean = price;
        this.divingID = divID;
    }
    public EquipmentBean (String id, Integer type, String size, String avail, String desc, Double price){
        this.idBean = id;
        this.equipType = type;
        this.sizeBean = size;
        this.availBean = avail;
        this.descrBean = desc;
        this.priceBean = price;
    }
    public EquipmentBean(){}

    public String getIdBean() {
        return idBean;
    }

    public void setIdBean(String idBean) {
        this.idBean = idBean;
    }

    public Integer getEquipType() {
        return equipType;
    }

    public void setEquipType(Integer equipType) {
        this.equipType = equipType;
    }

    public String getSizeBean() {
        return sizeBean;
    }

    public void setSizeBean(String sizeBean) {
        this.sizeBean = sizeBean;
    }

    public String getAvailBean() {
        return availBean;
    }

    public void setAvailBean(String availBean) {
        this.availBean = availBean;
    }

    public String getDescrBean() {
        return descrBean;
    }

    public void setDescrBean(String descrBean) {
        this.descrBean = descrBean;
    }

    public Double getPriceBean() {
        return priceBean;
    }

    public void setPriceBean(Double priceBean) {
        this.priceBean = priceBean;
    }

    public String getDivingID() {
        return divingID;
    }

    public void setDivingID(String divingID) {
        this.divingID = divingID;
    }
}
