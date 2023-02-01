package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.GestioneDivingControllerApplicativo;
import com.example.dw_1.applicativo.ProfiloUtenteControllerApplicativo;
import com.example.dw_1.bean.DivingBean;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ManagerDivingCenterControllerGrafico { // mostra i diving center associati ad un manager (creare associazione con il manager)

    @FXML
    private Button addDiving; // inserisciDiving metodo relativo

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
    private ListView<DivingBean> divingView;

    private static final Integer ADD_DIVING_CENTER = 0;
    private static final Integer MODIFY_DIVING_CENTER = 1;
    private static final Integer MANGER_HOME = 2;

    public void initialized(URL location, ResourceBundle resources) {
        GestioneDivingControllerApplicativo gestioneDivingControllerApplicativo = new GestioneDivingControllerApplicativo();
        gestioneDivingControllerApplicativo.setUserBean(ProfiloUtenteControllerApplicativo.getInstance().getLoggedUser());

        List<DivingBean> divingBeanList = gestioneDivingControllerApplicativo.getAllDiving();
        divingView.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) ->{
            divingID.setText(newValue.getDivingId());
            divingName.setText(newValue.getDivingName());
            divingManger.setText(newValue.getDivingManager());
            divingLocation.setText(newValue.getLocation());
            divingTelephone.setText(newValue.getTelephone());

        }));
        divingView.getItems().clear();
        divingView.setItems(FXCollections.observableList(divingBeanList));
    }
    @FXML
    void onButtonClicked(ActionEvent event) throws IOException {
        Button sourceButton = (Button) event.getSource();
        Integer nextScreen;
        if (sourceButton == addDiving) {
            nextScreen = ADD_DIVING_CENTER;
        } else if (sourceButton == modifyDiving) {
            nextScreen = MODIFY_DIVING_CENTER;
        } else {
            nextScreen = null;
        }
        if (nextScreen != null){
            switch (nextScreen) {
                case 0 :
                        DiversWorld dw = new DiversWorld();
                        dw.changeScene("divingCenterManagement.fxml");
                    break;
                case 1:
                        DiversWorld dw1 = new DiversWorld();
                        dw1.changeScene("divingCenterManagement.fxml");
                    break;
                default: nextScreen = MANGER_HOME;
            }
        }

    }

}
