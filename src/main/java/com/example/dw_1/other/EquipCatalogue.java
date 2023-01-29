package com.example.dw_1.other;

import com.example.dw_1.entity.Equipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EquipCatalogue {
    private final List<Equipment> equipArrayList;

    public EquipCatalogue(List<Equipment> equips){
        this.equipArrayList = equips;
    }
    public List<Equipment> filterByType(String equipType){
        List<Equipment> filteredEquipArray = new ArrayList<>();
        for (Equipment equipment : equipArrayList) {
            if(equipment.getType().contains(equipType)){
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
    public void addEquuip (Equipment newEquip){
        this.equipArrayList.add(newEquip);
    }
}
