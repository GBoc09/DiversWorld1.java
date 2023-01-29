package com.example.dw_1.bean;

public class EquipmentBean implements Bean {
    private Integer idBean;
    private String nameBean;
    private String sizeBean;
    private String availBean;
    private String descrBean;
    private Double priceBean;

    public EquipmentBean(){
        this.idBean = 0;
        this.nameBean = "";
        this.sizeBean= "";
        this.availBean= "";
        this.descrBean = "";
        this.priceBean = 0.0;
    }
    public EquipmentBean(Integer id) {
        this.idBean = id;
        this.nameBean = "";
        this.sizeBean= "";
        this.availBean= "";
        this.descrBean = "";
        this.priceBean = 0.0;
    }
    public EquipmentBean(Integer id, String name, String size, String avail, String desc, Double price){
        setIdBean(id);
        setNameBean(name);
        setSizeBean(size);
        setAvailBean(avail);
        setDescrBean(desc);
        setPriceBean(price);
    }

    public Integer getIdBean() {
        return idBean;
    }

    public void setIdBean(Integer idBean) {
        this.idBean = idBean;
    }

    public String getNameBean() {
        return nameBean;
    }

    public void setNameBean(String typeBean) {
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
}
