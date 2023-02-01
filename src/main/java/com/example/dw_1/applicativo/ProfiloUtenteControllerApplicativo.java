package com.example.dw_1.applicativo;

import com.example.dw_1.bean.UserBean;
import com.example.dw_1.dao.ScubaDAO;
import com.example.dw_1.dao.UserDAO;
import com.example.dw_1.entity.Scuba;
import com.example.dw_1.entity.User;
import com.example.dw_1.exception.NotExistantException;
/*
*  NON FUNZIONA ANCORA IL CARICAMENTO DEI DATI ALL' INTERNO DEL PROFILO DELL'UTENTE
* */
public class ProfiloUtenteControllerApplicativo{
   public UserBean visualizzaDati(UserBean userBean) throws NotExistantException {
       UserBean user = new UserBean();
       String license = userBean.getLicense();
       ScubaDAO scubaDAO = new ScubaDAO();
       UserDAO userDAO = new UserDAO();
       Scuba scuba = scubaDAO.loadScubaByLicense(license);
       User user1 = userDAO.selectUserLicense(license);
       user.setLicense(scuba.getLicense());
       user.setUserEmail(user1.getEmail());
       user.setName(user1.getName());
       user.setLastname(user1.getLastname());

       return user;



   }
}
