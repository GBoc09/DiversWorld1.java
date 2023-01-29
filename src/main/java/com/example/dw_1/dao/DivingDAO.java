package com.example.dw_1.dao;

public class DivingDAO {
    private static final String DIVING_ID = "id";
    private static final String DIVING_NAME = "name";
    private static final  String DIVING_MANAGER = "divingManager";
    private static final String DIVING_LOCATION = "location";
    private static final String DIVING_TELEPHONE  =  "telephone";

    private String mangerLicense;

    public String getMangerLicense() {
        return mangerLicense;
    }

    public void setMangerLicense(String mangerLicense) {
        this.mangerLicense = mangerLicense;
    }
}
