package com.example.dw_1.grafico;
        import com.example.dw_1.DiversWorld;
        import com.example.dw_1.applicativo.RegistazioneControllerApplicativo;
        import com.example.dw_1.bean.UserBean;
        import com.example.dw_1.exception.AlreadyRegisteredUserException;
        import com.example.dw_1.exception.InvalidCredentialException;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.*;

        import java.io.IOException;
        import java.util.logging.Logger;


public class RegistrationControllerGrafico {

    @FXML
    private TextField email;

    @FXML
    private TextField lastname;

    @FXML
    private TextField license;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password1;
    @FXML
    private ToggleGroup attivita;
    @FXML
    private RadioButton freeCheck;
    @FXML
    private RadioButton managerCheck;
    @FXML
    private RadioButton scubaCheck;


    private int userType;

    @FXML
    private Button signUp; /* its relatives method is REGISTRAZIONE */
    @FXML
    private Label errorLabel;

    /* --------- dichiarazione delle variabili UESR TYPE --------- */
    public static final int SCUBA_TYPE = 0;
    public static final int FREE_TYPE = 1;
    public static final int MANAGER_TYPE = 2;
    public static final int NOT_LOG = -1;

    UserBean userBean;
    private Integer type;

        @FXML
    void signUp(ActionEvent event) throws AlreadyRegisteredUserException, IOException, InvalidCredentialException {
            try {
                userBean = insertInfo();
                RegistazioneControllerApplicativo registazioneControllerApplicativo = new RegistazioneControllerApplicativo();
                registazioneControllerApplicativo.registrazione(userBean);
                type = userBean.getUserType();
                switch (type){
                    case 0:
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
                    default: type = NOT_LOG;
                }
            } catch (AlreadyRegisteredUserException e){
                errorLabel.setText("You are already registered!");
                throw new AlreadyRegisteredUserException(1);
            } catch (InvalidCredentialException e) {
                throw new InvalidCredentialException("Credential non found");
            }
        }
    private UserBean insertInfo() throws InvalidCredentialException {
        UserBean user = new UserBean();
        user.setUserEmail(email.getText());
        user.setPassword(password.getText());
        user.setName(name.getText());
        user.setLastname(lastname.getText());
        user.setLicense(license.getText());


        if (scubaCheck.isSelected()) {
            userType = SCUBA_TYPE;
        } else if (freeCheck.isSelected()) {
            userType = FREE_TYPE;
        } else if (managerCheck.isSelected()) {
            userType= MANAGER_TYPE;
        }
        user.setUserType(userType);

        if(email.getText().isEmpty() || password.getText().isEmpty()|| name.getText().isEmpty()|| lastname.getText().isEmpty() || license.getText().isEmpty()){
            throw new InvalidCredentialException("Invalid fields");
        }
        return user;

    }



}

