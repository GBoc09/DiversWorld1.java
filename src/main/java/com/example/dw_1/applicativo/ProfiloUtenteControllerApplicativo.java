package com.example.dw_1.applicativo;

/*
*  NON FUNZIONA ANCORA IL CARICAMENTO DEI DATI ALL' INTERNO DEL PROFILO DELL'UTENTE
* */

import com.example.dw_1.bean.UserBean;
import com.example.dw_1.dao.ScubaDAO;
import com.example.dw_1.entity.Scuba;
import com.example.dw_1.exception.NotExistantException;

public class ProfiloUtenteControllerApplicativo{
    private Scuba scuba;
    public void loadScuba (UserBean userBean) throws NotExistantException {
        if (userBean == null ) throw new NotExistantException("Error");
        ScubaDAO scubaDAO = new ScubaDAO();
        scuba = scubaDAO.loadScubaByEmail(userBean.getUserEmail());
    }
}
