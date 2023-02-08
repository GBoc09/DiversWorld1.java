package com.example.dw_1.bean;

import java.util.List;

public class EquipmentBean implements Bean {
    private String idEquip;
    private String idDiving;
    private String equipType;
    private String size;
    private String avail;
    private Double price;
    public EquipmentBean(){}
    public EquipmentBean(String codeEquip, String codeDiving, String type, String taglia, String disp, Double prezzo){
        this.idEquip = codeEquip;
        this.idDiving = codeDiving;
        this.equipType = type;
        this.size = taglia;
        this.avail = disp;
        this.price = prezzo;
    }
    public EquipmentBean(String codeEquip, String type, String taglia, String disp, Double prezzo){
        this.idEquip = codeEquip;
        this.equipType = type;
        this.size = taglia;
        this.avail = disp;
        this.price = prezzo;
    }
    public EquipmentBean( String type){
        this.equipType = type;
    }
    public EquipmentBean(List<EquipmentBean> e){}

    public String getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(String idEquip) {
        this.idEquip = idEquip;
    }

    public String getIdDiving() {
        return idDiving;
    }

    public void setIdDiving(String idDiving) {
        this.idDiving = idDiving;
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAvail() {
        return avail;
    }

    public void setAvail(String avail) {
        this.avail = avail;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
