package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.GestioneDivingControllerApplicativo;
import com.example.dw_1.bean.DivingBean;
import com.example.dw_1.exception.AlreadyRegisteredDiving;
import com.example.dw_1.exception.AlreadyRegisteredUserException;
import com.example.dw_1.exception.InvalidCredentialException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModifyDivingCenterControllerGrafico { // fxml associato = DIVING CENTER MANAGEMENT

    @FXML
    private TextField divingID;

    @FXML
    private TextField divingLoc;

    @FXML
    private TextField divingMan;

    @FXML
    private TextField divingName;

    @FXML
    private TextField divingPhone;
    @FXML
    private Label errorLabel;

    @FXML
    private Button goOn;

    Logger logger;
    DivingBean divingBean;
    @FXML
    void goOn(ActionEvent event) throws IOException, AlreadyRegisteredDiving {
        try{
            divingBean = insertInfo();
            GestioneDivingControllerApplicativo gestioneDivingControllerApplicativo = new GestioneDivingControllerApplicativo();
            gestioneDivingControllerApplicativo.registrazioneDiving(divingBean);
            DiversWorld dw = new DiversWorld();
            dw.changeScene("divingCenter.fxml");
        } catch (AlreadyRegisteredDiving e){
            errorLabel.setText("You have already inserted this diving");
            throw new AlreadyRegisteredDiving(1);
        }
    }
    private DivingBean insertInfo(){
        DivingBean diving = new DivingBean();
        diving.setDivingId(divingID.getText());
        diving.setDivingName(divingName.getText());
        diving.setDivingManager(divingMan.getText());
        diving.setLocation(divingLoc.getText());
        diving.setTelephone(divingPhone.getText());
        return diving;
    }
    @FXML
    void goHome(MouseEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("manager_home.fxml");
        } catch (Exception e){
            logger.log(Level.INFO, "Exception Error");
        }

    }

}
