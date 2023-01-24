package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
