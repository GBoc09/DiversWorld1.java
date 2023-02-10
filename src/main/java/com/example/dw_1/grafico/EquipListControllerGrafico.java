package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.GestioneEquipControllerApplicativo;
import com.example.dw_1.bean.EquipmentBean;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EquipListControllerGrafico implements Initializable {

    @FXML
    private Label goHome;

    @FXML
    private ListView<String> listView;
    @FXML
    private Button choose;
    @FXML
    private Label idEquip;
    Logger logger = Logger.getLogger(EquipListControllerGrafico.class.getName());

    @FXML
    void goHome(MouseEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("scuba_home.fxml");
        } catch (Exception e){
            logger.log(Level.INFO, "Exception Error");
        }
    }
    @FXML
    void onButtonClicked(ActionEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("cart.fxml");
        } catch (Exception e){
            logger.log(Level.INFO, "Exception Error");
        }
    }
    public int index;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choose.setDisable(true);
        final String[] str1 = new String[1];

        GestioneEquipControllerApplicativo gestione = new GestioneEquipControllerApplicativo();
        List<EquipmentBean> equipmentBeanList = gestione.getEquips();
        for (EquipmentBean d : equipmentBeanList) {
            listView.getItems().add("EquipID: " + d.getIdEquip() + ", " + "DivingID: " + d.getIdDiving() + ", " + "EquipType: " +
                    d.getEquipType() + ", " + "Size: " + d.getSize() + ", " + "Availability:" + d.getAvail() + ", " + "Price: " + d.getPrice());
            listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    str1[0] = listView.getSelectionModel().getSelectedItem();
                    idEquip.setText(str1[0]);
                    index = listView.getSelectionModel().getSelectedIndex();
                    CartContrellerGrafico cartGrafico = new CartContrellerGrafico();
                    cartGrafico.memoryIndex(index);
                }
            });

            choose.setDisable(false);
        }

    }
}


