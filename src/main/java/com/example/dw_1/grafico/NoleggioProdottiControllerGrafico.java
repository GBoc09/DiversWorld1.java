package com.example.dw_1.grafico;

import com.example.dw_1.bean.DivingBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

public class NoleggioProdottiControllerGrafico {
    ObservableList<String> equipList = FXCollections.observableArrayList("Jacket", "Regulator", "Mask", "Finns", "Weight", "Suit");
    ObservableList<String> sizeList = FXCollections.observableArrayList("none","XS", "S", "M", "L", "XL");
    @FXML
    private Button divingList;

    @FXML
    private ChoiceBox<String> equipType;

    @FXML
    private Button search;

    @FXML
    private ChoiceBox<String> size;

    @FXML
    private CheckBox viewAll;
    @FXML
    private ListView<DivingBean> divingListView;
    public NoleggioProdottiControllerGrafico(){
        divingListView = new ListView<>();
    }

    @FXML
    void divingList(ActionEvent event) {

    }

    @FXML
    void serchItem(ActionEvent event) {

    }
    @FXML
    private void initialize() {
        size.setItems(sizeList);
        size.setValue("select size");
        equipType.setItems(equipList);
        equipType.setValue("select equipment");
    }




}