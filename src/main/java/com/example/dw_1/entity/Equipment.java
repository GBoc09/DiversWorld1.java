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

    }

}
