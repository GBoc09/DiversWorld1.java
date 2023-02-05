package com.example.dw_1.applicativo;

import com.example.dw_1.bean.EquipmentBean;
import com.example.dw_1.dao.EquipmentDAO;
import com.example.dw_1.entity.Equipment;
import com.example.dw_1.pattern.Factory;

public class GestioneEquipControllerApplicativo {
    Factory factory;
    public GestioneEquipControllerApplicativo () {
        factory = new Factory();
    }
    public void addEquip(EquipmentBean equipmentBean){
        Equipment equipment;
        Integer id = equipmentBean.getIdBean();
        String name = equipmentBean.getNameBean();
        String size = equipmentBean.getSizeBean();
        String avail = equipmentBean.getAvailBean();
        String desc = equipmentBean.getDescrBean();
        Double price = equipmentBean.getPriceBean();
        EquipmentDAO equipmentDAO = new EquipmentDAO();
        equipment = factory.createEquip(id,name, size, avail, desc, price);
        equipmentDAO.insertProduct(equipment);
    }

}
