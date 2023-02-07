package com.example.dw_1.applicativo;

/*
*  NON FUNZIONA ANCORA IL CARICAMENTO DEI DATI ALL' INTERNO DEL PROFILO DELL'UTENTE
* */

import com.example.dw_1.dao.UserDAO;

import java.util.List;

/**
 * interroghiamo il db dal dao
 * e ci faccciamo restituire delle stringhe
 * passiamo le stringhe al controller applicativo
 * lui le passa al controller grafico
 * e le inserisce nell'initialize per visualizzarli a schermo */
public class ProfiloUtenteControllerApplicativo{
    public List<String> visualizzaDati(){
        UserDAO userDAO = new UserDAO();
        List<String> user = userDAO.datiUtenti();
        System.out.println(user);
        return user;
    }


}
