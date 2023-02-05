package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.ProfiloUtenteControllerApplicativo;
import com.example.dw_1.bean.LoginBean;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.exception.NotExistantException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
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

    Logger logger = Logger.getLogger(ScubaHomeControllerGrafico.class.getName());
    /* NON FUNZIONA QUESTA FUNZIONE */
     @FXML
    void visualizzaProfilo(MouseEvent event) throws IOException, NotExistantException {
         UserBean userBean = new UserBean();
         ProfiloUtenteControllerApplicativo profilo = new ProfiloUtenteControllerApplicativo();
         profilo.loadScuba(userBean);
         DiversWorld dw = new DiversWorld();
         dw.changeScene("profiloScuba.fxml");

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
