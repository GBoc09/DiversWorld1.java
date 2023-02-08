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
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private ImageView profilo;
    private Integer notLog = -1;
    @FXML
    void accedi(ActionEvent event) throws InvalidCredentialException, IOException, NotExistantException { /* function ACCEDI is related to the login button in the login screen */
        Integer userType;
        Node eventSource = (Node) event.getSource();
        if (eventSource == entry) {
            if (email.getText().isEmpty() || userPass.getText().isEmpty()){
                errorLabel.setText("Please insert your credentials");
                email.setText("");
                userPass.setText("");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Fill all required fields");
                alert.showAndWait();
                throw new InvalidCredentialException("Please insert valid credentials");
            }
            UserBean userBean = login();
            userType = userBean.getUserType();
            if (userBean != null ) {
                switch (userType) {
                    case 0:
                            LoginControllerGrafico.userEmail1 = userBean.getUserEmail();
                            DiversWorld dw = new DiversWorld();
                            dw.changeScene("scuba_home.fxml");
                    break;
                    case 1:
                            DiversWorld dw1 = new DiversWorld();
                            dw1.changeScene("free_home.fxml");
                        break;
                    case 2:

                            DiversWorld dw2 = new DiversWorld();
                            dw2.changeScene("manager_home.fxml");
                        break;
                    default: userType = notLog;
                    errorLabel.setText("User not found, please create an account");
                    throw new NotExistantException("User not logged");
                }
            }
        }
    }
    Logger logger = Logger.getLogger(LoginControllerGrafico.class.getName());
    @FXML
    void createAccount(ActionEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("registration.fxml");
        }
        catch (Exception e){
            logger.log(Level.INFO, "Exception Error");
        }

    }
    private UserBean login () throws NotExistantException {
        String userEmail = email.getText();
        String password = userPass.getText();
        LoginBean loginBean = new LoginBean(userEmail, password);
        LoginControllerApplicativo loginControllerApplicativo = new LoginControllerApplicativo();

        UserBean loggedUser = null;

        try {
            loggedUser = loginControllerApplicativo.verifyUser(loginBean);

        } catch (NotExistantException e){
                throw new NotExistantException("---User not found---");
        }
        return loggedUser;
    }
    static String userEmail1 = "";
    public static String getUserEmail1() {
        return userEmail1;
    }

    /**  LA FUNZIONE SCRITTA FUNZIONE MA SOLO SE COLLEGATA ALL'INSERIMETO DEI DATI DURANTE IL LOG IN */
    private UserBean utente;
    public UserBean utenteLoggato () throws NotExistantException {
        String userEmail = email.getText();
        LoginBean loginBean = new LoginBean(userEmail);
        LoginControllerApplicativo loginControllerApplicativo = new LoginControllerApplicativo();

        try {
            utente = loginControllerApplicativo.verifyUserEmail(loginBean);
            setUtente(utente);
        } catch (NotExistantException e){
            throw new NotExistantException("--- emeil not found --- ");
        }
        return utente;
    }
    private static LoginControllerGrafico loginControllerGrafico;
    public static LoginControllerGrafico getInstance(){
        if(loginControllerGrafico == null){
            loginControllerGrafico = new LoginControllerGrafico();
        }
        return loginControllerGrafico;
    }

    public UserBean getUtente() {
        return utente;
    }

    public void setUtente(UserBean utente) {
        this.utente = utente;
    }

    /** FXML per gestione FREE divers page */

        @FXML
        private Button bookCourse;

        @FXML
        private Label goToLogin;

        @FXML
        private Button logBook;

        @FXML
        void goToLogin(MouseEvent event) {
            try{
                DiversWorld dw = new DiversWorld();
                dw.changeScene("login.fxml");
            }
            catch (Exception e){
                logger.log(Level.INFO, "Exception Error");
            }

        }
}

