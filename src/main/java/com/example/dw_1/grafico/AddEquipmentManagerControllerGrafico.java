package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddEquipmentManagerControllerGrafico {
    ObservableList<String> equipList = FXCollections.observableArrayList("Jacket", "Regulator", "Mask", "Finns", "Weight", "Suit");
    ObservableList<String> sizeList = FXCollections.observableArrayList("none","XS", "S", "M", "L", "XL");
    @FXML
    private Button addProduct;

    @FXML
    private TextField availability;

    @FXML
    private TextField description;

    @FXML
    private TextField id;
    @FXML
    private Label goHome;


    @FXML
    private TextField price;

    @FXML
    private ChoiceBox<String> size;

    @FXML
    private ChoiceBox<String> type;

    @FXML
    private void initialize() {
        size.setItems(sizeList);
        size.setValue("select size");
        type.setItems(equipList);
        type.setValue("select type");
    }
    @FXML
    void addNewProduct(ActionEvent event) { /* aggiungere al catalogo delle attrzzature */
        Node sourceNode = (Node) event.getSource();

    }
    @FXML
    void goHome(MouseEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("manager_home.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }



}