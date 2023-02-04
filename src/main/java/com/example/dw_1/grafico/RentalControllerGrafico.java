package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RentalControllerGrafico {
    /* RENTAL SCREEN FXML */
    @FXML
    private Button addItem;

    @FXML
    private Button viewCart;
    @FXML
    private Label goHome;
    Logger logger;

    @FXML
    void goToNoleggia(ActionEvent event) { /* nel caso in cui si volessero aggiungere altri items */
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("noleggioEquip.fxml");
        } catch (Exception e) {
            logger.log(Level.INFO, "Exception Error");
        }
    }

    @FXML
    void viewCart(ActionEvent event) {
        // CREARE FXML
    }
    @FXML
    void goHome(MouseEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("scuba_home.fxml");
        } catch (Exception e) {
            logger.log(Level.INFO, "Exception Error");
        }
    }


}
