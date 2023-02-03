package com.example.dw_1.applicativo;

import com.example.dw_1.bean.LoginBean;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.dao.UserDAO;
import com.example.dw_1.exception.NotExistantException;

public class LoginControllerApplicativo {
    public static final Integer NOT_LOGGED = -1;
    private UserBean loggedUser = null;
    private  static LoginControllerApplicativo loginControllerApplicativo = new LoginControllerApplicativo();
    public static LoginControllerApplicativo getInstance(){
        if (loginControllerApplicativo == null){
            loginControllerApplicativo = new LoginControllerApplicativo();
        }
        return loginControllerApplicativo;
    }
    public UserBean verifyUser(LoginBean loginData) throws NotExistantException {
        UserDAO userDAO = new UserDAO();
        Integer userType = userDAO.selectUser(loginData.getUserEmail(), loginData.getUserPassword());
        return new UserBean(loginData.getUserEmail(), userType);
    }
    public UserBean getLoggedUser(){
        return loggedUser;
    }

    public void setLoggedUser(UserBean loggedUser) {
        this.loggedUser = loggedUser;
    }
}

