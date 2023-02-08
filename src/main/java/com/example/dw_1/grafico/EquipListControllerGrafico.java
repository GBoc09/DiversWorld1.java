package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.GestioneEquipControllerApplicativo;
import com.example.dw_1.bean.EquipmentBean;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
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
            dw.changeScene("noleggioEquip.fxml");
        } catch (Exception e){
            logger.log(Level.INFO, "Exception Error");
        }
    }
   @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       GestioneEquipControllerApplicativo gestione = new GestioneEquipControllerApplicativo();
       List<EquipmentBean> equipmentBeanList = gestione.getEquips();
       for (EquipmentBean d : equipmentBeanList) {
           listView.getItems().add("EquipID: " + d.getIdEquip() + ", " + "DivingID: " + d.getIdDiving() + ", " + "EquipType: " +
                   d.getEquipType() + ", " + "Size: " + d.getSize() + ", " + "Availability:" + d.getAvail() + ", " + "Price: " + d.getPrice());
       }
   }
}


