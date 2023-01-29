package com.example.dw_1.entity;

public class Equipment {
    private Integer id;
    private String type;
    private String size;
    private String availability;
    private String description;
    private Double price;
    // private Diving diving;

    public Equipment() {
        this.id = 0;
        this.type = "";
        this.size = "";
        this.availability = "";
        this.description = "";
        this.price = 0.0;
    }
    public Equipment (Integer id, String type, String size, String availability, String description, Double price){
        setId(id);
        setType(type);
        setSize(size);
        setAvailability(availability);
        setDescription(description);
        setPrice(price);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
