package com.example.dw_1.entity;

public class Equipment {
    private String idEquip;
    private String size;
    private String avail;
    private Double price;
    private String equipType;
    private String divingID; /* riferimento al DIVING ID*/

    public Equipment() {}
    public Equipment(String idE, String idD, String tipo, String taglia, String disp, Double prezzo){
        this.idEquip = idE;
        this.divingID = idD;
        this.equipType = tipo;
        this.size = taglia;
        this.avail = disp;
        this.price = prezzo;
    }

    public String getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(String idEquip) {
        this.idEquip = idEquip;
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

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public String getDivingID() {
        return divingID;
    }

    public void setDivingID(String divingID) {
        this.divingID = divingID;
    }
}