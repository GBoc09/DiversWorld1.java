package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;

import com.example.dw_1.applicativo.LoginControllerApplicativo;
import com.example.dw_1.bean.LoginBean;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.exception.NotExistantException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginControllerGrafico {
    @FXML
    private Button entry;
    @FXML
    private Button createAccout;
    @FXML
    private TextField email;

    @FXML
    private PasswordField userPass;


    @FXML
    void accedi(ActionEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("login.fxml");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
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

