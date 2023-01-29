package com.example.dw_1.bean;

public class EquipmentBean {
    private Integer idBean;
    private String typeBean;
    private String sizeBean;
    private String availBean;
    private String descrBean;
    private Double priceBean;

    public EquipmentBean(){
        this.idBean = 0;
        this.typeBean = "";
        this.sizeBean= "";
        this.availBean= "";
        this.descrBean = "";
        this.priceBean = 0.0;
    }
    public EquipmentBean(Integer id) {
        this.idBean = id;
        this.typeBean = "";
        this.sizeBean= "";
        this.availBean= "";
        this.descrBean = "";
        this.priceBean = 0.0;
    }
    public EquipmentBean(Integer id, String type, String size, String avail, String desc, Double price){
        setIdBean(id);
        setTypeBean(type);
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

    public String getTypeBean() {
        return typeBean;
    }

    public void setTypeBean(String typeBean) {
        this.typeBean = typeBean;
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
