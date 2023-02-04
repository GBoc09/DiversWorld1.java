package com.example.dw_1.bean;

public class ValidationBean implements  Bean{
     /* verifico che l'utente sia un manager */
    private String manager;

    public ValidationBean(String manager){
        this.manager = manager;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
