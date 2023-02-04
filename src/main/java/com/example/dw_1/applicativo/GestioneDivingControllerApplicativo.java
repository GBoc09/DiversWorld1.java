package com.example.dw_1.applicativo;

import com.example.dw_1.bean.DivingBean;
import com.example.dw_1.bean.LoginBean;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.bean.ValidationBean;
import com.example.dw_1.dao.DivingDAO;
import com.example.dw_1.dao.UserDAO;
import com.example.dw_1.entity.Diving;
import com.example.dw_1.exception.AlreadyRegisteredDiving;
import com.example.dw_1.exception.AlreadyRegisteredUserException;
import com.example.dw_1.exception.NotExistantException;
import com.example.dw_1.other.DivingCatalogue;
import com.example.dw_1.pattern.Factory;

import java.util.ArrayList;
import java.util.List;

public class GestioneDivingControllerApplicativo {
   Factory factory;
   public GestioneDivingControllerApplicativo(){ factory = new Factory();}
    public void registrazioneDiving (DivingBean divingBean) throws AlreadyRegisteredDiving {
       Diving diving;
       String id = divingBean.getDivingId();
       String name = divingBean.getDivingName();
       String manager = divingBean.getDivingManager();
       String loc = divingBean.getLocation();
       String tel = divingBean.getTelephone();
       diving = factory.createDiving(id, name, manager,loc,tel);
       DivingDAO divingDAO = new DivingDAO();
       divingDAO.insertDiving(diving);
    }
   public DivingBean verifyDiving(DivingBean divingBean) throws NotExistantException {
      DivingDAO divingDAO = new DivingDAO();
      String diving = divingDAO.findDivingByName(divingBean.getDivingName());
      return new DivingBean(diving, divingBean.getLocation());
   }
   public ValidationBean verifyManager(ValidationBean validationBean) throws NotExistantException {
      UserDAO userDAO = new UserDAO();
      String user = userDAO.selectLicense(validationBean.getManager());
      return new ValidationBean(user);
   }


}