package com.example.dw_1.grafico;
        import com.example.dw_1.applicativo.LoginControllerApplicativo;
        import com.example.dw_1.bean.RegistrationBean;
        import com.example.dw_1.exception.AlreadyRegisteredUserException;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.*;

        import java.sql.Date;
        import java.time.ZoneId;

        import static java.util.Date.from;

public class RegistrationControllerGrafico {
    @FXML
    private DatePicker birthDate;

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
    private Button signIn;
    @FXML
    private Label errorLabel;

    LoginControllerApplicativo regController = new LoginControllerApplicativo();
    @FXML
    void registrazione(ActionEvent event) throws AlreadyRegisteredUserException {
        RegistrationBean rBean = new RegistrationBean();
        if (Boolean.FALSE.equals(verfyInsert(rBean))){
            return;
        }
        regController.registrazione(rBean);

    }
    private Boolean verfyInsert(RegistrationBean rBean) {
        if (Boolean.TRUE.equals(checkEmpty())){
            errorLabel.setText("Insert all fields");
            return false;
        }
        if (birthDate.getValue() == null) {
            errorLabel.setText("Insert a birth date");
            return false;
        }
        if (!password.getText().equals(password1.getText())){
            errorLabel.setText("Password field must be the same");
            return false;
        }
        if(Boolean.FALSE.equals(rBean.validateName(name.getText()))) {
            errorLabel.setText("Insert a correct name");
            return false;
        }else {
            rBean.setName(name.getText());
        }
        if(Boolean.FALSE.equals(rBean.validateLastname(lastname.getText()))){
            errorLabel.setText("Insert a correct lastname");
            return false;
        } else {
            rBean.setLastname(lastname.getText());
        }
        if(Boolean.FALSE.equals(rBean.validateEmail(email.getText()))){
            errorLabel.setText("Insert a correct email");
            return false;
        } else {
            rBean.setEmail(email.getText());
        }
       /* if(Boolean.FALSE.equals(rBean.validatePassword(password.getText()))){
            errorLabel.setText("Insert a correct password [4-16 chars, containing numbers, letters]");
            return false;
        } else {
            rBean.setPassword(password.getText());
        }*/
        System.out.println(birthDate.getValue());



        return true;
    }
    public Boolean checkEmpty(){
        TextField[] arrayOFNodes = {name, lastname, email, password, password1};
        for(TextField field: arrayOFNodes) {
            if(field.getText().equals("")){
                return true;
            }
        }
        return false;
    }

}

