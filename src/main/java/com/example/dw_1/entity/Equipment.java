package com.example.dw_1.entity;

public class Equipment {
    private Integer id;
    private String name;
    private String size;
    private String availability;
    private String description;
    private Double price;
    private Diving diving; /* riferimento al DIVING ID*/

    public Equipment() {
        this.id = 0;
        this.name = "";
        this.size = "";
        this.availability = "";
        this.description = "";
        this.price = 0.0;
        this.diving = null;
    }
    public Equipment (Integer id, String name, String size, String availability, String description, Double price, Diving diving){
        setId(id);
        setName(name);
        setSize(size);
        setAvailability(availability);
        setDescription(description);
        setPrice(price);
        setDiving(diving);

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

    public Diving getDiving() {
        return diving;
    }

    public void setDiving(Diving diving) {
        this.diving = diving;
    }
}