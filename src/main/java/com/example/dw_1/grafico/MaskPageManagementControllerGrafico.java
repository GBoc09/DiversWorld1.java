package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MaskPageManagementControllerGrafico {
    /* MASK PAGE FXML */
    @FXML
    private Label availLabelMask;

    @FXML
    private TextField descMask;

    @FXML
    private TextField idMask;

    @FXML
    private TextField nameMask;

    @FXML
    private TextField priceMask;

    @FXML
    private Button selectItem;
    @FXML
    private Label goHome;


    @FXML
    void goHome(MouseEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("noleggioEquip.fxml");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void selectItem(ActionEvent event) {

    }
}
