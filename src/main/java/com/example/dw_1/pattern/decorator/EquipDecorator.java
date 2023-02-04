package com.example.dw_1.pattern.decorator;

import com.example.dw_1.entity.EquipInterface;

import java.util.List;

public abstract class EquipDecorator  extends EquipInterface {
   private EquipInterface equip;
   public EquipDecorator (EquipInterface equipInterface) {
       this.equip = equipInterface;
   }
   @Override
    public List<String> equipment (){
       List<String> result = this.equip.equipment();
       return result;
   }
}
