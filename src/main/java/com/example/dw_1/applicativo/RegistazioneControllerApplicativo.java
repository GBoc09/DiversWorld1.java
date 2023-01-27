package com.example.dw_1.applicativo;

import com.example.dw_1.bean.RegistrationBean;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.dao.FreeDAO;
import com.example.dw_1.dao.ManagerDAO;
import com.example.dw_1.dao.ScubaDAO;
import com.example.dw_1.entity.Scuba;
import com.example.dw_1.entity.User;
import com.example.dw_1.exception.AlreadyRegisteredUserException;
import com.example.dw_1.pattern.Factory;

public class RegistazioneControllerApplicativo {
    Factory factory;
    public RegistazioneControllerApplicativo() {
        factory = new Factory();
    }
    public void registrazione (UserBean userBean) throws AlreadyRegisteredUserException{
        User scuba;
        User free;
        User manager;
        int type = userBean.getUserType();
        System.out.println("registrazione controller applicativo: REGISTRAZIONE");
        String name = userBean.getName();
        System.out.println(name);
        String lastname = userBean.getLastname();
        System.out.println(lastname);
        String email = userBean.getUserEmail();
        System.out.println(email);
        String password = userBean.getPassword();
        System.out.println(password);
        String license = userBean.getLicense();
        System.out.println(license);
        if ( type == 0) {
            scuba = factory.createScuba(email, password, name, lastname,license);
            ScubaDAO scubaDAO = new ScubaDAO();
            scubaDAO.insertScuba(scuba);
        } else if (type == 1) {
            free = factory.createFree(email, password, name, lastname,license);
            FreeDAO freeDAO = new FreeDAO();
            freeDAO.insertFree(free);
        } else if (type == 2) {
            manager = factory.createManager(email, password, name, lastname, license);
            ManagerDAO managerDAO = new ManagerDAO();
            managerDAO.insertManager(manager);

        }

    }

}
