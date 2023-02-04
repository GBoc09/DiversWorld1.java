package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RegulatorPageManagementControllerGrafico {
    /* REGULATOR PAGE FXML */
    @FXML
    private Label availLabelReg;

    @FXML
    private TextField descReg;

    @FXML
    private Label goHome;

    @FXML
    private TextField idReg;

    @FXML
    private TextField nameReg;

    @FXML
    private TextField priceReg;

   @FXML
    private Button selectItem;
   @FXML
    void selectItem(ActionEvent event){}
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
