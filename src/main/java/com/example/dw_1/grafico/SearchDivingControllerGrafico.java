package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.GestioneDivingControllerApplicativo;
import com.example.dw_1.bean.DivingBean;
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

public class SearchDivingControllerGrafico { // SCHERMATA RICERCA DIVING

    @FXML
    private TextField divingLoc;

    @FXML
    private TextField divingName;

    @FXML
    private Label errorLabel;

    @FXML
    private Label goHome;

    @FXML
    private Button search;

    @FXML
    void goHome(MouseEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("scuba_home.fxml");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
/* collegamento con la pagina di scelta delle attrezzature */
    @FXML
    void serchDiving(ActionEvent event) throws NotFoundDivingException, InvalidCredentialException, IOException {
        Node eventSource = (Node) event.getSource();
        if (eventSource == search) {
            if (divingName.getText().isEmpty() || divingLoc.getText().isEmpty()) {
                errorLabel.setText("Please insert your credentials");
                divingName.setText("");
                divingLoc.setText("");
                throw new InvalidCredentialException("Please insert valid credentials");
            }
            DivingBean divingBean = sceltaDiving();
            String nome = divingBean.getDivingName();
            if ( nome != null){
                DiversWorld dw = new DiversWorld();
                dw.changeScene("noleggioEquip.fxml");
            } else {
                throw new NotFoundDivingException("--- Diving not found --- ");
            }

        }
    }
/* verifica che il diving inserito dall'utente sia all'interno del DB
*    ********FUNZIONANTE ******** */

    private DivingBean sceltaDiving() throws NotFoundDivingException {
        String nomeDiving = divingName.getText();
        String cityDiving = divingLoc.getText();
        DivingBean divingBean = new DivingBean(nomeDiving, cityDiving);

        GestioneDivingControllerApplicativo gestioneDivingControllerApplicativo = new GestioneDivingControllerApplicativo();
        DivingBean d = null;
        if (divingBean != null) {
            try {
                d = gestioneDivingControllerApplicativo.verifyDiving(divingBean);
            } catch (NotExistantException e){
                errorLabel.setText("Diving not found");
                throw new NotFoundDivingException("Diving not found");
            }
        }
        return d;
    }
}