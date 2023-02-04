package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FinnsPageManagementControllerGrafico {
    /* FINN PAGE FXML */
    @FXML
    private Label availLabelFinn;

    @FXML
    private TextField descFinn;

    @FXML
    private TextField idFinn;

    @FXML
    private TextField nameFinn;

    @FXML
    private TextField priceFinn;

    @FXML
    private ChoiceBox<String> sizeFinn;
    public void initialize (){
        sizeFinn.setItems(FXCollections.observableArrayList("XS", "S", "M", "L", "XL"));
        sizeFinn.setValue("Choose the size");
    }

    @FXML
    private Button selectItem;

    @FXML
    private Label goHome;
    Logger logger;
    @FXML
    void goHome(MouseEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("noleggioEquip.fxml");
        } catch (Exception e) {
            logger.log(Level.INFO, "Exception Error");
        }

    }

    @FXML
    void selectItem(ActionEvent event) {
        // to do
    }
}
