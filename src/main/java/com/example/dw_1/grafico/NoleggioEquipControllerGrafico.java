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
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("finnsPage.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void showJacket(ActionEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("jacketPage.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

    @FXML
    void showMask(ActionEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("maskPage.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void showRegolator(ActionEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("regulatorPage.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

    @FXML
    void showSuit(ActionEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("suitPage.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

}
