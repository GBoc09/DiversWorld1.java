package com.example.dw_1.bean;

public class EquipmentBean implements Bean {
    private Integer idBean;
    private String nameBean;
    private String sizeBean;
    private String availBean;
    private String descrBean;
    private Double priceBean;
    private String divingID;

    public EquipmentBean (Integer id, String name, String size, String avail, String desc, Double price, String divID){
        this.idBean = id;
        this.nameBean = name;
        this.sizeBean = size;
        this.availBean = avail;
        this.descrBean = desc;
        this.priceBean = price;
        this.divingID = divID;
    }
    public EquipmentBean (Integer id, String name, String size, String avail, String desc, Double price){
        this.idBean = id;
        this.nameBean = name;
        this.sizeBean = size;
        this.availBean = avail;
        this.descrBean = desc;
        this.priceBean = price;
    }
    public EquipmentBean(){}

    public Integer getIdBean() {
        return idBean;
    }

    public void setIdBean(Integer idBean) {
        this.idBean = idBean;
    }

    public String getNameBean() {
        return nameBean;
    }

    public void setNameBean(String nameBean) {
        this.nameBean = nameBean;
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
