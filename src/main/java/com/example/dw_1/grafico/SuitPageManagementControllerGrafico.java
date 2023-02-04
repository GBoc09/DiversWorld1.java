package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SuitPageManagementControllerGrafico {

    @FXML
    private Label availLabelSuit;

    @FXML
    private TextField descSuit;

    @FXML
    private Label goHome;

    @FXML
    private TextField idSuit;

    @FXML
    private TextField nameSuit;

    @FXML
    private TextField priceSuit;

    @FXML
    private Button selectItem;

    @FXML
    private ChoiceBox<?> sizeSuit;

    @FXML
    void goHome(MouseEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("scuba_home.fxml");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void selectItem(ActionEvent event) {

    }

}

