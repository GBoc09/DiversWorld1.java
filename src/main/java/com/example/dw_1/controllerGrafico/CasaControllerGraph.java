package com.example.dw_1.controllerGrafico;

import com.example.dw_1.DiversWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CasaControllerGraph {
    @FXML
    private Button login;

    @FXML
    void loginButtonClicked(ActionEvent event) throws IOException {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("login.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

}
