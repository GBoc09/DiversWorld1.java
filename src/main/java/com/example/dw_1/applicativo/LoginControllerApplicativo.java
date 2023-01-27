package com.example.dw_1.applicativo;

import com.example.dw_1.bean.LoginBean;
import com.example.dw_1.bean.RegistrationBean;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.dao.UserDAO;
import com.example.dw_1.entity.User;
import com.example.dw_1.exception.AlreadyRegisteredUserException;
import com.example.dw_1.exception.NotExistantException;
import com.example.dw_1.exception.WrongLoginCredentialException;

public class LoginControllerApplicativo {
    public UserBean verifyUser(LoginBean loginData) throws NotExistantException {
        UserDAO userDAO = new UserDAO();

        Integer userType = userDAO.selectUser(loginData.getUserEmail(), loginData.getUserPassword());
        return new UserBean(loginData.getUserEmail(), userType);
    }
}

