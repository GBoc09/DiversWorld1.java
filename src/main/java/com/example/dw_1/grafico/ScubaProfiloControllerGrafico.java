package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.bean.UserBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ScubaProfiloControllerGrafico {
    @FXML
    private Button modificaProfilo;
    @FXML
    private TextField textLicense;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textLastname;

    @FXML
    private TextField textName;

    @FXML
    private PasswordField textPass;
    @FXML
    private Label backHome;

    @FXML
    void backToScubaHome(MouseEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("scuba_home.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

    @FXML
    void modificaProfilo(ActionEvent event) {
        // dummy
    }
}
