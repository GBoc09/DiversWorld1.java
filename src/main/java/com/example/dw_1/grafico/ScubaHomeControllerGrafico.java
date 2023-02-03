package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.ProfiloUtenteControllerApplicativo;
import com.example.dw_1.bean.LoginBean;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.dao.ScubaDAO;
import com.example.dw_1.entity.Scuba;
import com.example.dw_1.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ScubaHomeControllerGrafico {
    @FXML
    private Button modificaProfilo;
    @FXML
    private TextField textLicense;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textLastname;

    @FXML
    private TextField textName;

    @FXML
    private PasswordField textPass;
    @FXML
    private Label backHome;
    LoginBean loginBean;
    /* NON FUNZIONA PER NULLA QUESTA FUNZIONE */
     @FXML
    void visualizzaProfilo(MouseEvent event) {
        try{
            ProfiloUtenteControllerApplicativo profiloUtenteControllerApplicativo = new ProfiloUtenteControllerApplicativo();
            profiloUtenteControllerApplicativo.visualizzaDatiProva(loginBean);

            DiversWorld dw = new DiversWorld();
            dw.changeScene("profiloScuba.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
/* inizio use case */
    @FXML
    void rentEquip(ActionEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("searchDiving.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

}
