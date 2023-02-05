package com.example.dw_1.other;

import com.example.dw_1.entity.Equipment;

import java.util.List;

public class EquipCatalogue {
    private final List<Equipment> equipArrayList;
    public EquipCatalogue(List<Equipment> equips){
        this.equipArrayList = equips;
    }
    public void addEquip(Equipment newEquip){
        this.equipArrayList.add(newEquip);
    }


}
