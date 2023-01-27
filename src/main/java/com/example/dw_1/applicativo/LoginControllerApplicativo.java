package com.example.dw_1.applicativo;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.bean.LoginBean;
import com.example.dw_1.bean.RegistrationBean;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.dao.UserDAO;
import com.example.dw_1.entity.User;
import com.example.dw_1.exception.AlreadyRegisteredUserException;
import com.example.dw_1.exception.NotExistantException;
import com.example.dw_1.exception.WrongLoginCredentialException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.dw_1.grafico.RegistrationControllerGrafico.SCUBA_TYPE;
import static com.example.dw_1.grafico.RegistrationControllerGrafico.FREE_TYPE;
import static com.example.dw_1.grafico.RegistrationControllerGrafico.MANAGER_TYPE;


public class LoginControllerApplicativo {
    public static final String SCUBA_HOME_SCREEN = "scuba_home.fxml";
    public static final String FREE_HOME_SCREEN = "free_home.fxml";
    public static final String MANAGER_HOME_SCREEN = "manager_home.fxml";
    public static final Integer NOT_LOGGED = -1;

    private UserBean loggedUser;
    private static LoginControllerApplicativo loginControllerApplicativo;
    public UserBean verifyUser(LoginBean loginData) throws NotExistantException {
        UserDAO userDAO = new UserDAO();

        Integer userType = userDAO.selectUser(loginData.getUserEmail(), loginData.getUserPassword());
        return new UserBean(loginData.getUserEmail(), userType);
    }

     public void setLoggedUser(UserBean userBean){
        this.loggedUser = loggedUser;
     }
     public static LoginControllerApplicativo getLoginInstance() {
        if(loginControllerApplicativo == null){
            loginControllerApplicativo = new LoginControllerApplicativo();
        }
        return loginControllerApplicativo;
     }
}

