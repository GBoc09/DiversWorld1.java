package com.example.dw_1.other;

import com.example.dw_1.entity.Diving;

import java.util.ArrayList;
import java.util.List;

public class DivingCatalogue {
    private List<Diving> divingList;

    public DivingCatalogue (){
        this.divingList = new ArrayList<>();
    }
    public DivingCatalogue(List<Diving> divingList){
        this.divingList = divingList;
    }

    public void setDivingList(List<Diving> divings) {
        this.divingList = divings;
    }
    public List<Diving> getDivings(){
        return this.divingList;
    }
    public void addDiving (Diving newDiving){
        divingList.add(newDiving);
    }
    public Diving createDiving (String divingID, String name, String manager, String loc, String tel){
        return new Diving(divingID, name, manager, loc, tel);
    }
    public void addDving (String divingID, String name, String manager, String loc, String tel){
        Diving localDiving = new Diving(divingID, name, manager, loc, tel);
        divingList.add(localDiving);
    }
    public Diving getDivingByName (String name){
        for (Diving diving : this.divingList){
            if(diving.getName().compareTo(name) == 0){
                return diving;
            }
        }
        return null;
    }
    public boolean removeDiving(String name){
        for (Diving diving: divingList){
            if(diving.getName().compareTo(name) == 0){
                divingList.remove(diving);
                return true;
            }
        }
        return false;
    }



}
