package com.example.dw_1.applicativo;

import com.example.dw_1.bean.LoginBean;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.dao.ScubaDAO;
import com.example.dw_1.dao.UserDAO;
import com.example.dw_1.entity.Scuba;
import com.example.dw_1.entity.User;

/*
*  NON FUNZIONA ANCORA IL CARICAMENTO DEI DATI ALL' INTERNO DEL PROFILO DELL'UTENTE
* */
public class ProfiloUtenteControllerApplicativo{
    private UserBean userBean;
    private ProfiloUtenteControllerApplicativo profiloUtenteControllerApplicativo = new ProfiloUtenteControllerApplicativo();

/* CREARE UNA VARIALBILE PER L'UTENTE LOGGATO IN CUI SI SALVA ALMENO LA MAIL IN MODO DA POTER AVERE SEMPRE A DISPOSIZIONE QUESTA VARIABILE */
  public UserBean  visualizzaDatiProva(LoginBean loginBean){
        String userEmail = userBean.getUserEmail();
        System.out.println(userEmail);
        ScubaDAO scubaDAO = new ScubaDAO();
        Scuba scuba = scubaDAO.loadScubaByEmail(userEmail);
        return new UserBean(scuba.getEmail(), scuba.getPassword(), scuba.getName(), scuba.getLastname(), scuba.getLicense());
  }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
