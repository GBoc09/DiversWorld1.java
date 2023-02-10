package com.example.dw_1.other;

public enum NotificationType {
    ORDER("ORDER"),
    REQUEST("REQUEST"),
        APPROVAL("APPROVAL");
    private String type;
    private NotificationType(String type){
        this.type = type;
    }
    @Override
    public String toString (){
        return type;
    }
}
