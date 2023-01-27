package com.example.dw_1.grafico;
        import com.example.dw_1.applicativo.RegistazioneControllerApplicativo;
        import com.example.dw_1.bean.UserBean;
        import com.example.dw_1.exception.AlreadyRegisteredUserException;
        import com.example.dw_1.exception.InvalidCredentialException;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.*;

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
    private int userType;

    @FXML
    private Button signIn; /* its relatives method is REGISTRAZIONE */
    @FXML
    private Label errorLabel;
    UserBean userBean;

        @FXML
    void signIn(ActionEvent event) throws AlreadyRegisteredUserException {

            try {
                userBean = insertInfo();
                RegistazioneControllerApplicativo registazioneControllerApplicativo = new RegistazioneControllerApplicativo();
                registazioneControllerApplicativo.registrazione(userBean);
            } catch (AlreadyRegisteredUserException e){
                throw new AlreadyRegisteredUserException(1);
            } catch (InvalidCredentialException e) {
                throw new RuntimeException(e);
            }
        }
    private UserBean insertInfo() throws InvalidCredentialException {
        UserBean userBean = new UserBean();
        userBean.setUserEmail(email.getText());
        userBean.setPassword(password.getText());
        userBean.setName(name.getText());
        userBean.setLastname(lastname.getText());
        userBean.setUserType(userType);

        if(email.getText().isEmpty() || password.getText().isEmpty()|| name.getText().isEmpty()|| lastname.getText().isEmpty()){
            throw new InvalidCredentialException("Invalid fields");
        }
        return userBean;

    }


}

