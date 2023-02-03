package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class RentalControllerGrafico { // RENTAL SCREEN FXML
    @FXML
    private Button addItem;

    @FXML
    private Button viewCart;
    @FXML
    private Label goHome;

    @FXML
    void goToNoleggia(ActionEvent event) { /* nel caso in cui si volessero aggiungere altri items */
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("noleggioEquip.fxml");
        } catch (Exception e) {
            System.err.println(e.getMessage());
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
            System.err.println(e.getMessage());
        }

    }

}
