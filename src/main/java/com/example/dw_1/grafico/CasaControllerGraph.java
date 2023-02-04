package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CasaControllerGraph {
    @FXML
    private Button access;

    Logger log;
    @FXML
    void accessButtonClicked(ActionEvent event) throws IOException {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("login.fxml");
        }
        catch (Exception e){
            log.log(Level.INFO, "Exception Error");
        }

    }

}
