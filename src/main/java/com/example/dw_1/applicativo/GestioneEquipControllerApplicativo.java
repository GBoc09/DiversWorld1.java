package com.example.dw_1.applicativo;

import com.example.dw_1.bean.EquipmentBean;
import com.example.dw_1.dao.*;
import com.example.dw_1.entity.*;
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
    public void addEquip(EquipmentBean equipmentBean) throws AlreadyRegisteredEquipException {
        Regulator reg;
        Mask mask;
        Jacket jack;
        Suit suit;
        Finns finns;
        int equipType = equipmentBean.getEquipType();
        String id = equipmentBean.getIdBean();
        String divingID = equipmentBean.getDivingID();
        String desc = equipmentBean.getDescrBean();
        String size = equipmentBean.getSizeBean();
        String avail = equipmentBean.getAvailBean();
        Double price = equipmentBean.getPriceBean();

        if (equipType == 0){
            jack = factory.createJack(id,divingID,desc,size, avail, price);
            JacketDAO jacketDAO = new JacketDAO();
            jacketDAO.insertJack(jack);
        } else if (equipType == 1) {
            reg = factory.createRegulator(id,divingID,desc,price, avail);
            RegulatorDAO regulatorDAO = new RegulatorDAO();
            regulatorDAO.insertReg(reg);
            
        } else if (equipType == 2) {
            finns = factory.createFinns(id,divingID,desc,size, avail, price);
            FinnsDAO finnsDAO = new FinnsDAO();
            finnsDAO.insertFinns(finns);
            
        } else if ( equipType == 3) {
            mask = factory.createMask(id,divingID,desc,price, avail);
            MaskDAO maskDAO = new MaskDAO();
            maskDAO.insertMask(mask);
        } else if (equipType == 4) {
            suit = factory.createSuit(id,divingID,desc,size, avail, price);
            SuitDAO suitDAO = new SuitDAO();
            suitDAO.insertSuit(suit);
        }
    }

}
