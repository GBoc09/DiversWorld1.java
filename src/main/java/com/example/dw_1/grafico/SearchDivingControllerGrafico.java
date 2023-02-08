package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.GestioneDivingControllerApplicativo;
import com.example.dw_1.bean.DivingBean;
import com.example.dw_1.exception.InvalidCredentialException;
import com.example.dw_1.exception.NotFoundDivingException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchDivingControllerGrafico { // SCHERMATA RICERCA DIVING

    @FXML
    private TextField divingLoc;

    @FXML
    private TextField divingName;

    @FXML
    private Label goHome;

    @FXML
    private Button search;
    Logger logger;
    @FXML
    void goHome(MouseEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("scuba_home.fxml");
        } catch (Exception e) {
                logger.log(Level.INFO, "Exception Error");
        }
    }
/* collegamento con la pagina di scelta delle attrezzature */
    @FXML
    void serchDiving(ActionEvent event) throws NotFoundDivingException, IOException {
        Node eventSource = (Node) event.getSource();
        if (eventSource == search) {
            if (divingName.getText().isEmpty() || divingLoc.getText().isEmpty()) {
                divingName.setText("");
                divingLoc.setText("");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Fill all required fields");
                alert.showAndWait();
            }
            DivingBean divingBean = sceltaDiving();
            String nome = divingBean.getDivingName();
            DivingBean divingBean1 = takeDivingCodeCntrl();
            String code = divingBean1.getDivingId();
            if ( nome != null && code != null){
                DiversWorld dw = new DiversWorld();
                dw.changeScene("equipList.fxml");
            } else {
                throw new NotFoundDivingException("--- Diving not found --- ");
            }
        }
    }
/* verifica che il diving inserito dall'utente sia all'interno del DB
*    ********FUNZIONANTE ******** */

    private DivingBean sceltaDiving()  {
        String nomeDiving = divingName.getText();
        String cityDiving = divingLoc.getText();
        DivingBean divingBean = new DivingBean(nomeDiving, cityDiving);

        GestioneDivingControllerApplicativo gestioneDivingControllerApplicativo = new GestioneDivingControllerApplicativo();
        DivingBean d = null;
        if (divingBean != null) {
            d = gestioneDivingControllerApplicativo.verifyDiving(divingBean);
        }
        return d;
    }
    private DivingBean takeDivingCodeCntrl () {
        String nomeDiving = divingName.getText();
        DivingBean divingBean = new DivingBean(nomeDiving);
        GestioneDivingControllerApplicativo gestione = new GestioneDivingControllerApplicativo();
        DivingBean d;
        d = gestione.takeDivingCode(divingBean);
        return d;
    }
}