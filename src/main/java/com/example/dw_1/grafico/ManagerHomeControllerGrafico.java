package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ManagerHomeControllerGrafico {
    @FXML
    private Button addEqup;

    @FXML
    void aggiungiEquip(ActionEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("addEquip.fxml");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
