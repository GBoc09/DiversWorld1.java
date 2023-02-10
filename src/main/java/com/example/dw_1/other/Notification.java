package com.example.dw_1.other;

import java.util.HashMap;
import java.util.Map;

public class Notification {
    private String sender = "";
    private NotificationType type;
    private HashMap<String, String> options = new HashMap<>();

    public String getSender() {
        return sender;
    }

    public NotificationType getType() {
        return type;
    }
    public Map<String, String> getParameters(){
        return options;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }
    public void addParameter(String key, String value){
        options.put(key, value);
    }
    public void setParameters(Map<String, String> options){
        this.options = (HashMap<String, String>) options;
    }
}
