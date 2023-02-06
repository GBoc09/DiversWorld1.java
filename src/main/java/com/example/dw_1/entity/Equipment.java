package com.example.dw_1.entity;

public class Equipment {
    private String id;
    private String size;
    private String availability;
    private String description;
    private Double price;
    private String diving; /* riferimento al DIVING ID*/

    public Equipment() {}
    public Equipment (String id,String diving,String description,Double price,String availability ){
        this.id = id;
        this.diving = diving;
        this.description = description;
        this.price = price;
        this.availability = availability;
    }
    public Equipment (String id,String diving,String description,String size, String availability, Double price){
        this.id = id;
        this.diving = diving;
        this.description = description;
        this.size = size;
        this.availability = availability;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDiving() {
        return diving;
    }

    public void setDiving(String diving) {
        this.diving = diving;
    }
}