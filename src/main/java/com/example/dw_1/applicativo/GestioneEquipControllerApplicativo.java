package com.example.dw_1.applicativo;

import com.example.dw_1.bean.DivingBean;
import com.example.dw_1.bean.EquipmentBean;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.dao.EquipmentDAO;
import com.example.dw_1.entity.Diving;
import com.example.dw_1.entity.Equipment;
import com.example.dw_1.exception.DuplicateItemException;
import com.example.dw_1.exception.InvalidItemException;
import com.example.dw_1.other.EquipCatalogue;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class GestioneEquipControllerApplicativo {
    public void addEquip(EquipmentBean equipmentBean, DivingBean divingBean) throws SQLException, DuplicateItemException, InvalidItemException {
        EquipmentDAO equipmentDAO = new EquipmentDAO();
        EquipCatalogue equipCatalogue = equipmentDAO.loadEquipByID(divingBean.getDivingId());
        Diving diving = new Diving(divingBean.getDivingId(), divingBean.getDivingName(), divingBean.getLocation(), divingBean.getTelephone());
        Equipment equipment = new Equipment(equipmentBean.getIdBean(), equipmentBean.getNameBean(), equipmentBean.getSizeBean(),equipmentBean.getAvailBean(), equipmentBean.getDescrBean(), equipmentBean.getPriceBean(), diving);
        equipment.setDiving(diving);
        List<Equipment> equips = EquipCatalogue.filterByName(equipment.getName());
        for (Equipment locEquip : equips){
            if(controlDuplicatedItem(locEquip, equipment)){
                throw new DuplicateItemException("This item is already in the catalogue");
            }
        }
        equipCatalogue.addEquip(equipment);
        if (!equipmentDAO.insertProduct(equipment)){
            throw new InvalidItemException("Invalid item");
        }
    }
    private boolean controlDuplicatedItem(Equipment localEquip, Equipment equip) {

        return (Objects.equals(localEquip.getDescription(), equip.getDescription())) && (Objects.equals(localEquip.getPrice(), equip.getPrice()));

    }
}
