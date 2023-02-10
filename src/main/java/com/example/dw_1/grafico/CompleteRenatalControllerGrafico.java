package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CompleteRenatalControllerGrafico {

    @FXML
    private Button backToHomePage;

    @FXML
    private Label goHome;
    Logger logger = Logger.getLogger(CompleteRenatalControllerGrafico.class.getName());
    private String message = " Exception Error";
    @FXML
    void backToHomePage(ActionEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("scuba_home.fxml");
        } catch (Exception e){
            logger.log(Level.INFO, message);
        }
    }

    @FXML
    void goHome(MouseEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("scuba_home.fxml");
        } catch (Exception e){
            logger.log(Level.INFO, message);
        }
    }

}

