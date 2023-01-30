package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.ProfiloUtenteControllerApplicativo;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.dao.ScubaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ScubaHomeControllerGrafico {
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
    UserBean userBean;
    @FXML
    void visualizzaProfilo(MouseEvent event) {
        try{
            userBean = insertInfo();
            ProfiloUtenteControllerApplicativo profiloUtenteControllerApplicativo = new ProfiloUtenteControllerApplicativo();
            profiloUtenteControllerApplicativo.visualizzaDati(userBean);
            DiversWorld dw = new DiversWorld();
            dw.changeScene("profiloScuba.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    private UserBean insertInfo(){
    UserBean user = new UserBean();
        user.setUserEmail(textEmail.getText());
        user.setPassword(textPass.getText());
        user.setName(textName.getText());
        user.setLastname(textLastname.getText());
        user.setLicense(textLicense.getText());
         return user;
    }
    @FXML
    void rentEquip(ActionEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("prodottiNoleggio.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

}
