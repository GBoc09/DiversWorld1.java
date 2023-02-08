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

public class JacketPageManagementControllerGrafico {
    /* JACKET PAGE FXML  */
    @FXML
    private Label availLabelJack;

    @FXML
    private Label goHome;

    @FXML
    private TextField idJacK;

    @FXML
    private TextField nameJack;

    @FXML
    private TextField priceJack;

    @FXML
    private Button selectItem;

    @FXML
    private ChoiceBox<String> sizeJack;
    Logger logger = Logger.getLogger(JacketPageManagementControllerGrafico.class.getName());
    @FXML
     void goHome(MouseEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("noleggioEquip.fxml");
        } catch (Exception e) {
            logger.log(Level.INFO, "Exception Error");
        }
     }
    public void initialize (){
        sizeJack.setItems(FXCollections.observableArrayList("XS", "S", "M", "L", "XL"));
        sizeJack.setValue("Choose the size");
    }
    @FXML
    void selectItem(ActionEvent event) {
        // to do
    }
}
