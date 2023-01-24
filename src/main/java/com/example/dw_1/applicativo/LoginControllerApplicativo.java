package com.example.dw_1.applicativo;

import com.example.dw_1.bean.LoginBean;
import com.example.dw_1.bean.RegistrationBean;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.dao.UserDAO;
import com.example.dw_1.entity.User;
import com.example.dw_1.exception.AlreadyRegisteredUserException;
import com.example.dw_1.exception.WrongLoginCredentialException;

public class LoginControllerApplicativo {
    public void registrazione(RegistrationBean newUserData) throws AlreadyRegisteredUserException {
        /* verifichiamo se la stessa email possa gia essere inserita all'interno della BD */
        UserDAO userDB = new UserDAO();
        User newUser = new User();
        newUser.setName(newUserData.getName());
        newUser.setLastname(newUserData.getLastname());
        newUser.setEmail(newUserData.getEmail());
        newUser.setPassword(newUserData.getPassword());
        newUser.setBirthDate(newUserData.getBirthDate());
        newUser.setLicense(newUser.getLicense());

        userDB.insertUser(newUser);
    }
    public void accesso(LoginBean userData) throws WrongLoginCredentialException {
        UserDAO userDB = new UserDAO();
        User loggedUser = userDB.selectLoginUser(userData.getUserID());
        if (!loggedUser.getPassword().equals(userData.getPassword())) {
            throw new WrongLoginCredentialException(1);
        }
    }
    public UserBean getUserByLoginData(LoginBean loginData) {
        var bean = new UserBean();
        UserDAO userDAO = new UserDAO();

        User loggedUser = userDAO.selectUser(loginData.getUserID());

        bean.setName(loggedUser.getName());
        bean.setLastname(loggedUser.getLastname());
        bean.setLicense(loggedUser.getLicense());
        return null;
    }
   /* public void logout(UserBean loggedUser){
        SessionHandler session = new SessionHandler();
        ConnectionServer serverInstance = ConnectionServer.getInstance();
        String ip = serverInstance.getConnectionData().getIp();
    }*/
}

