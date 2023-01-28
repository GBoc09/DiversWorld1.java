package com.example.dw_1.grafico;
        import com.example.dw_1.applicativo.RegistazioneControllerApplicativo;
        import com.example.dw_1.bean.UserBean;
        import com.example.dw_1.entity.User;
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
    private Button signIn; /* its relatives method is REGISTRAZIONE */
    @FXML
    private Label errorLabel;

    /* --------- dichiarazione delle variabili UESR TYPE --------- */
    public static final int SCUBA_TYPE = 0;
    public static final int FREE_TYPE = 1;
    public static final int MANAGER_TYPE = 2;

    public static final String SCUBA_SCREEN = "scuba_home.fxml";
    public static final String FREE_SCREEN = "free_home.fxml";
    public static final String MANAGER_SCREEN = "manager_home.fxml";

    UserBean userBean;

        @FXML
    void signIn(ActionEvent event) throws AlreadyRegisteredUserException {
            try {
                userBean = insertInfo();
                RegistazioneControllerApplicativo registazioneControllerApplicativo = new RegistazioneControllerApplicativo();
                registazioneControllerApplicativo.registrazione(userBean);
                System.out.println("registrazione con successo");
            } catch (AlreadyRegisteredUserException e){
                throw new AlreadyRegisteredUserException(1);
            } catch (InvalidCredentialException e) {
                throw new RuntimeException(e);
            }
        }
    private UserBean insertInfo() throws InvalidCredentialException {
        UserBean userBean = new UserBean();
        System.out.println("registration controller grafico: INSERT INFO");
        userBean.setUserEmail(email.getText());
        System.out.println(email);
        userBean.setPassword(password.getText());
        System.out.println(password);
        userBean.setName(name.getText());
        System.out.println(name);
        userBean.setLastname(lastname.getText());
        System.out.println(lastname);
        userBean.setLicense(license.getText());
        System.out.println(license);

        if (scubaCheck.isSelected()) {
            userType = SCUBA_TYPE;
        } else if (freeCheck.isSelected()) {
            userType = FREE_TYPE;
        } else if (managerCheck.isSelected()) {
            userType= MANAGER_TYPE;
        }
        userBean.setUserType(userType);

        if(email.getText().isEmpty() || password.getText().isEmpty()|| name.getText().isEmpty()|| lastname.getText().isEmpty() || license.getText().isEmpty()){
            throw new InvalidCredentialException("Invalid fields");
        }
        return userBean;

    }



}

