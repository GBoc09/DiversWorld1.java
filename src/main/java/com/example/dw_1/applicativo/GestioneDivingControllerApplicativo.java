package com.example.dw_1.applicativo;

import com.example.dw_1.bean.DivingBean;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.bean.ValidationBean;
import com.example.dw_1.dao.DivingDAO;
import com.example.dw_1.dao.ManagerDAO;
import com.example.dw_1.dao.UserDAO;
import com.example.dw_1.entity.Diving;
import com.example.dw_1.entity.Manager;
import com.example.dw_1.exception.AlreadyRegisteredDiving;
import com.example.dw_1.other.DivingCatalogue;
import com.example.dw_1.pattern.factory.Factory;
import javafx.scene.control.Label;

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
   public DivingBean verifyDiving(DivingBean divingBean) {
      DivingDAO divingDAO = new DivingDAO();
      String diving = divingDAO.findDivingByName(divingBean.getDivingName());
      return new DivingBean(diving, divingBean.getLocation());
   }
   public ValidationBean verifyManager(ValidationBean validationBean) {
      UserDAO userDAO = new UserDAO();
      String user = userDAO.selectLicense(validationBean.getManager());
      return new ValidationBean(user);
   }
   public List<DivingBean> getAllDiving(UserBean userBean){
      DivingDAO divingDAO = new DivingDAO();
      ManagerDAO managerDAO = new ManagerDAO();
      Manager manager = managerDAO.loadManager(userBean.getUserEmail());
      System.out.println(manager.getEmail());
      DivingCatalogue divingCatalogue = divingDAO.loadAllDivingByManager(manager.getEmail());
      List<Diving> divings = divingCatalogue.getDivings();
      String divingName;
      ArrayList<DivingBean> divingBeanArrayList = new ArrayList<>();
      for (Diving diving : divings){
         divingName = diving.getName();
         System.out.println(divingName);
      }
      return divingBeanArrayList;
   }


}
