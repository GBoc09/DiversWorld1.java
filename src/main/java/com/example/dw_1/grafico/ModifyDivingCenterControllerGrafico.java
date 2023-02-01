package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.bean.DivingBean;
import com.example.dw_1.exception.InvalidCredentialException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ModifyDivingCenterControllerGrafico { // fxml associato = DIVING CENTER MANAGEMENT

    @FXML
    private TextField divingID;

    @FXML
    private TextField divingLoc;

    @FXML
    private TextField divingMan;

    @FXML
    private TextField divingName;

    @FXML
    private TextField divingPhone;

    @FXML
    private Button goOn;

    @FXML
    void goOn(ActionEvent event) throws IOException, InvalidCredentialException {
        DivingBean divingBean = null;
        Node source = (Node) event.getSource();
        if (source == goOn){
            divingBean = new DivingBean(divingID.getText(), divingName.getText(), divingMan.getText(), divingLoc.getText(), divingPhone.getText());
        }
        divingBean.setDivingId(divingBean.getDivingId());

        divingBean.setDivingName(divingBean.getDivingName());

        divingBean.setDivingManager(divingBean.getDivingManager());

        divingBean.setLocation(divingBean.getLocation());

        divingBean.setTelephone(divingBean.getTelephone());
        if (divingBean != null ){
            DiversWorld dw = new DiversWorld();
            dw.changeScene("divingCenter.fxml");
    } else {
            throw new InvalidCredentialException("Please compile all fields");
        }
    }
    @FXML
    void goHome(MouseEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("manager_home.fxml");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

}
