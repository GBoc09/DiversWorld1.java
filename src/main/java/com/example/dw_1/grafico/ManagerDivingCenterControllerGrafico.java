package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;

import com.example.dw_1.applicativo.GestioneDivingControllerApplicativo;
import com.example.dw_1.bean.DivingBean;
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

public class ManagerDivingCenterControllerGrafico  implements Initializable { // mostra i diving center associati ad un manager (creare associazione con il manager)

    @FXML
    private Label divingID;

    @FXML
    private Label divingLocation;

    @FXML
    private Label divingManger;

    @FXML
    private Label divingName;

    @FXML
    private Label divingTelephone;
    @FXML
    private Button modifyDiving;
    @FXML
    private ListView<String> listView;

    @FXML
    private Button home;

    @FXML
    private Label resultLabel;

    @FXML
    private Button showDiving;
    Logger logger = Logger.getLogger(ManagerDivingCenterControllerGrafico.class.getName());

    @FXML
    void onButtonClicked(ActionEvent event) throws IOException {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("divingCenterManagement.fxml");
        } catch (Exception e){
            logger.log(Level.INFO, mesasge);
        }


    }
    private String mesasge = "Exception Error";
    @FXML
    void goHome(MouseEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("manager_home.fxml");
        } catch (Exception e){
            logger.log(Level.INFO, mesasge);
        }
    }
    @FXML
    void showDiving(ActionEvent event ){
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("divingCenter.fxml");
        } catch (Exception e){
            logger.log(Level.INFO, mesasge);
         }
    }
    @FXML
    void goHome(ActionEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("manager_home.fxml");
        } catch (Exception e){
            logger.log(Level.INFO, mesasge);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GestioneDivingControllerApplicativo gestione = new GestioneDivingControllerApplicativo();
        /* controller chiama dao e si fa restiuire lista diving
        * passa a initialize una bean  */
        List<DivingBean> divingBeanList = gestione.getDivings();
        for (DivingBean d: divingBeanList) {
            listView.getItems().add(d.getDivingId()+","+d.getDivingName()+ ","+ d.getDivingManager() +","+ d.getLocation() + ","+ d.getTelephone() +"\n\n");
        }
    }
}
