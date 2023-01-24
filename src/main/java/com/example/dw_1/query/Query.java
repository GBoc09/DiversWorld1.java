package com.example.dw_1.query;
public abstract class Query {
    protected String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";
    protected String dateFormat = "yyyy-MM-dd";
    public String quote (String string){
        if (string != null) {
            return "\"" + string + "\"";
        }
        return string;
    }

}

