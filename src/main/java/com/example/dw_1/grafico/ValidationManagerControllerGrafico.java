package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.GestioneDivingControllerApplicativo;
import com.example.dw_1.bean.ValidationBean;
import com.example.dw_1.exception.InvalidCredentialException;
import com.example.dw_1.exception.NotExistantException;
import com.example.dw_1.exception.NotFoundDivingException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ValidationManagerControllerGrafico {

    @FXML
    private Button conferma;

    @FXML
    private Label goHome;

    @FXML
    private TextField validLabel;
    @FXML
    private Label errorLabel;

    @FXML
    void goHome(MouseEvent event) {

    }

    @FXML
    void validationManager(ActionEvent event) throws InvalidCredentialException, IOException, NotFoundDivingException, NotExistantException {
        Node source = (Node) event.getSource();
        if (source == conferma) {
            if (validLabel.getText().isEmpty()) {
                errorLabel.setText("Please insert valid license");
                validLabel.setText("");
                throw new InvalidCredentialException("Please insert valid credentials");
            }
            ValidationBean validationBean = validazioneManager();
            String manager = validationBean.getManager();
            if ( manager != null){
                DiversWorld dw = new DiversWorld();
                dw.changeScene("divingCenter.fxml");
            } else {
                throw new NotFoundDivingException("--- Diving not found --- ");
            }
        }

    }

    private ValidationBean validazioneManager() throws NotExistantException {
        String manager = validLabel.getText();
        ValidationBean validationBean = new ValidationBean(manager);
        GestioneDivingControllerApplicativo gestioneDivingControllerApplicativo = new GestioneDivingControllerApplicativo();

        ValidationBean v = null;
        if ( validationBean != null){
            v = gestioneDivingControllerApplicativo.verifyManager(validationBean);
        }
        return v;

    }

}
