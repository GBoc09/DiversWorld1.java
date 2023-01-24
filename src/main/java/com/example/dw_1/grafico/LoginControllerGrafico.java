package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginControllerGrafico {
    @FXML
    private Button entry;
    @FXML
    private Button createAccout;

    @FXML
    void accedi(ActionEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("login.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
    @FXML
    void createAccount(ActionEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("registration.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

}
