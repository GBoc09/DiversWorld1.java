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
    /* MODIFICARE LA FUNZIONE DI INSERIMENTO */
    public void addEquip(EquipmentBean equipmentBean) throws AlreadyRegisteredEquipException {
    // to do
    }
}
