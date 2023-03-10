package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerHomeControllerGrafico {
    @FXML
    private Button addCourse;

    @FXML
    private Button addEqup;
    @FXML
    private Button addDiving;

    @FXML
    private Button yourDivingCenter;
    @FXML
    private Label goToLogin;
    Logger logger;
    private String message = "Exception Error";
    @FXML
    void aggiungiEquip(ActionEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("addEquip.fxml");
        } catch (Exception e) {
            logger.log(Level.INFO, message);
        }

    }
    @FXML
    void aggiungiDiving(ActionEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("divingCenterManagement.fxml");
        } catch (Exception e) {
            logger.log(Level.INFO, message);
        }
    }
    @FXML
    void visualizzaDivingCenter(ActionEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("validazioneManager.fxml");
        } catch (Exception e) {
            logger.log(Level.INFO, message);
        }
    }
    @FXML
    void goToLogin(MouseEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("login.fxml");
        }
        catch (Exception e){
            logger.log(Level.INFO, "Exception Error");
        }
    }

}
