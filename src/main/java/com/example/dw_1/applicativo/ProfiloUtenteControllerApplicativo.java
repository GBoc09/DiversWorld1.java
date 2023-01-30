package com.example.dw_1.applicativo;

import com.example.dw_1.bean.UserBean;
import com.example.dw_1.dao.ScubaDAO;
import com.example.dw_1.entity.User;

public class ProfiloUtenteControllerApplicativo{
    User scuba;
   public void visualizzaDati(UserBean userBean) {
       int type = userBean.getUserType();
       String name = userBean.getName();
       String lastname = userBean.getLastname();
       String email = userBean.getUserEmail();
       String password = userBean.getPassword();
       String license = userBean.getLicense();
       ScubaDAO scubaDAO = new ScubaDAO();
       scubaDAO.loadScuba(scuba);
   }
}
