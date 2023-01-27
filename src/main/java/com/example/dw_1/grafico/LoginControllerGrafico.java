package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;

import com.example.dw_1.applicativo.LoginControllerApplicativo;
import com.example.dw_1.bean.LoginBean;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.exception.InvalidCredentialException;
import com.example.dw_1.exception.NotExistantException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginControllerGrafico {
    @FXML /* buttone di login per accedere se si hanno gia le credenziali*/
    private Button entry;
    @FXML
    private Button createAccout;
    @FXML
    private TextField email;

    @FXML
    private PasswordField userPass;
    @FXML
    private Label errorLabel;


    @FXML
    void accedi(ActionEvent event) throws InvalidCredentialException, IOException { /* function ACCEDI is related to the login button in the login screen */

        Node eventSource = (Node) event.getSource();
        Stage stage = (Stage) (eventSource).getScene().getWindow();
        if (eventSource == entry) {
            if (email.getText().isEmpty() || userPass.getText().isEmpty()){
                errorLabel.setText("Please insert your credentials");
                throw new InvalidCredentialException("Please insert valid credentials");
            }
            UserBean userBean = login();
            if (userBean != null) {
                try{
                    DiversWorld dw = new DiversWorld();
                    dw.changeScene("scuba_home.fxml");
                }
                catch (Exception e){
                    System.err.println(e.getMessage());
                }

            }
        }
    }
    @FXML
    void createAccount(ActionEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("registration.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
    private UserBean login (){
        String userEmail = email.getText();
        String password = userPass.getText();
        LoginBean loginBean = new LoginBean(userEmail, password);
        LoginControllerApplicativo loginControllerApplicativo = new LoginControllerApplicativo();

        UserBean loggedUser = null;
        try {
            loggedUser = loginControllerApplicativo.verifyUser(loginBean);
        } catch (NotExistantException e){

        }
        return loggedUser;
    }
}

