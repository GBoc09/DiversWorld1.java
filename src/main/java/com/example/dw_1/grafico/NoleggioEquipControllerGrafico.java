package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class NoleggioEquipControllerGrafico {
    @FXML
    private Button finn;

    @FXML
    private Label goHome;

    @FXML
    private Button jacket;

    @FXML
    private Button mask;

    @FXML
    private Button regulator;

    @FXML
    private Button suit;

    @FXML
    void goHome(MouseEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("scuba_home.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }


    }

    @FXML
    void showFinns(ActionEvent event) {

    }

    @FXML
    void showJacket(ActionEvent event) {

    }

    @FXML
    void showMask(ActionEvent event) {

    }

    @FXML
    void showRegolator(ActionEvent event) {

    }

    @FXML
    void showSuit(ActionEvent event) {

    }

}
