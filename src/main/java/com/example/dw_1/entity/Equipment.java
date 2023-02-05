package com.example.dw_1.entity;

public class Equipment {
    private Integer id;
    private String name;
    private String size;
    private String availability;
    private String description;
    private Double price;
    private String diving; /* riferimento al DIVING ID*/

    public Equipment() {}
    public Equipment (Integer id, String name, String size, String availability, String description, Double price, String diving){
        this.id = id;
        this.name = name;
        this.size = size;
        this.availability = availability;
        this.description = description;
        this.price = price;
        this.diving = diving;

    }
    public Equipment (Integer id, String name, String size, String availability, String description, Double price){
        this.id = id;
        this.name = name;
        this.size = size;
        this.availability = availability;
        this.description = description;
        this.price = price;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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