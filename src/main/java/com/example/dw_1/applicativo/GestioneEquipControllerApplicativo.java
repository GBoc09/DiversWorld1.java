package com.example.dw_1.applicativo;

import com.example.dw_1.bean.DivingBean;
import com.example.dw_1.bean.EquipmentBean;
import com.example.dw_1.dao.EquipmentDAO;
import com.example.dw_1.dao.JacketDAO;
import com.example.dw_1.entity.Equipment;
import com.example.dw_1.entity.Jacket;
import com.example.dw_1.exception.AlreadyRegisteredEquipException;
import com.example.dw_1.pattern.factory.Factory;

import java.util.ArrayList;
import java.util.List;

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
    public List<EquipmentBean> getEquips () {
        List<EquipmentBean> equip = new ArrayList<>();
        EquipmentDAO equipmentDAO = new EquipmentDAO();
        List<Equipment> equip2 = equipmentDAO.getEquipInfo();
        for (Equipment d : equip2) {
            EquipmentBean equipmentBean = new EquipmentBean();
            equipmentBean.setIdEquip(d.getIdEquip());
            equipmentBean.setIdDiving(d.getDivingID());
            equipmentBean.setEquipType(d.getEquipType());
            equipmentBean.setSize(d.getSize());
            equipmentBean.setAvail(d.getAvail());
            equipmentBean.setPrice(d.getPrice());
            equip.add(equipmentBean);
        }
        return equip;
    }
    /* PARAMETRI PRESI*/
    public EquipmentBean getSomeEquip(EquipmentBean equipmentBean) {
        List<EquipmentBean> equip = new ArrayList<>();
        JacketDAO jacketDAO = new JacketDAO();
        List<Jacket> equip2 = jacketDAO.getJackInfo(equipmentBean);
        for (Jacket j : equip2) {
            EquipmentBean e = new EquipmentBean();
            e.setIdEquip(j.getIdEquip());
            System.out.println(" nel ciclo for applicativo --- "+e.getIdEquip());
            e.setEquipType(j.getEquipType());
            System.out.println(" nel ciclo for applicativo --- "+e.getEquipType());
            e.setPrice(j.getPrice());
            System.out.println(" nel ciclo for applicativo --- "+e.getPrice());
            equip.add(e);
        }
        System.out.println(equip.get(0));
        return new EquipmentBean(equip);
    }
}
