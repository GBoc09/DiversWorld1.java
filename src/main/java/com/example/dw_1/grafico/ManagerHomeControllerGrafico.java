package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerHomeControllerGrafico {
    @FXML
    private Button addEqup;
    @FXML
    private Button addDiving;

    @FXML
    private Button yourDivingCenter;
    Logger logger;
    @FXML
    void aggiungiEquip(ActionEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("addEquip.fxml");
        } catch (Exception e) {
            logger.log(Level.INFO, "Exception Error");;
        }

    }
    @FXML
    void aggiungiDiving(ActionEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("divingCenterManagement.fxml");
        } catch (Exception e) {
            logger.log(Level.INFO, "Exception Error");
        }
    }
    @FXML
    void visualizzaDivingCenter(ActionEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("validazioneManager.fxml");
        } catch (Exception e) {
            logger.log(Level.INFO, "Exception Error");
        }
    }

}
