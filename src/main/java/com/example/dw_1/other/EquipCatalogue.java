package com.example.dw_1.other;

import com.example.dw_1.entity.Equipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EquipCatalogue {
    private static List<Equipment> equipArrayList;

    public EquipCatalogue(List<Equipment> equips){
        this.equipArrayList = equips;
    }
    public static List<Equipment> filterByName(String equipName){
        List<Equipment> filteredEquipArray = new ArrayList<>();
        for (Equipment equipment : equipArrayList) {
            if(equipment.getName().contains(equipName)){
                filteredEquipArray.add(equipment);
            }
        }
        return filteredEquipArray;
    }
    public Equipment getEquipById(Integer id){
        for (Equipment equipment: equipArrayList){
            if(Objects.equals(equipment.getId(), id)){
                return equipment;
            }
        }
        return null;
    }
    public void addEquip (Equipment newEquip){
        this.equipArrayList.add(newEquip);
    }
}
