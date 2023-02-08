package com.example.dw_1.applicativo;

import com.example.dw_1.bean.EquipmentBean;
import com.example.dw_1.dao.EquipmentDAO;
import com.example.dw_1.entity.Equipment;
import com.example.dw_1.exception.AlreadyRegisteredEquipException;
import com.example.dw_1.pattern.factory.Factory;
/* types:
* 0 = jacket
* 1 = regulator
* 2 = finns
* 3 = mask
* 4 = suit */
public class GestioneEquipControllerApplicativo {
    Factory factory;
    public GestioneEquipControllerApplicativo () {
        factory = new Factory();
    }
    /* MODIFICARE LA FUNZIONE DI INSERIMENTO */
    public void addEquip(EquipmentBean equipmentBean) throws AlreadyRegisteredEquipException {
        Equipment equipment;
        String idE = equipmentBean.getIdEquip();
        String idD = equipmentBean.getIdDiving();
        String equipT = equipmentBean.getEquipType();
        String size = equipmentBean.getSize();
        String avail = equipmentBean.getAvail();
        Double price = equipmentBean.getPrice();
        equipment = factory.createEquip(idE, idD, equipT, size, avail, price);
        EquipmentDAO equipmentDAO = new EquipmentDAO();
        equipmentDAO.insertEquip(equipment);

    }
}
