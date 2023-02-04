package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.ProfiloUtenteControllerApplicativo;
import com.example.dw_1.bean.LoginBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

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
    Logger logger;
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
            logger.log(Level.INFO, "Exception Error");
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
            logger.log(Level.INFO, "Exception Error");
        }

    }

}
