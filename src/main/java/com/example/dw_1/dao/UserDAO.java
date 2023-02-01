package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;

import com.example.dw_1.entity.User;
import com.example.dw_1.exception.NotExistantException;

import com.example.dw_1.query.UserQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserDAO {
    private static final String SCUBA_ENUM_TYPE = "scuba";
    private static final String FREE_ENUM_TYPE = "free";
    private static final String MANAGER_ENUM_TYPE = "manager";
    private static final String USER_TYPE = "type";
    private static final Integer SCUBA_TYPE = 0;
    private static final Integer FREE_TYPE = 1;
    private static final Integer MANAGER_TYPE = 2;
    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();
    UserQuery userQuery = new UserQuery();
    public Integer selectUser(String userEmail, String userPass) throws NotExistantException{
        Connection con =connection.getConnection();
        Integer userType = -1;
        try (Statement stmt = con.createStatement();
             ResultSet rs = UserQuery.selectUserByCredentials(stmt, userEmail, userPass);)
        {
            if(rs.next()){
                String userEnum = rs.getString(USER_TYPE);
                if (userEnum.compareTo(SCUBA_ENUM_TYPE) == 0){
                    userType = SCUBA_TYPE;
                } else if (userEnum.compareTo(FREE_ENUM_TYPE)== 0) {
                    userType = FREE_TYPE;

                } else if (userEnum.compareTo(MANAGER_ENUM_TYPE)== 0) {
                    userType = MANAGER_TYPE;

                }
            } else {
                throw new NotExistantException("User does not exist");
            }
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return userType;
    }
    public User selectUserLicense(String license){
        User user = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Connection con = connection.getConnection();
            stmt = con.createStatement();
            String query = userQuery.selectScubaByLicense(license);
            rs = stmt.executeQuery(query);

            if(!rs.next()){
                return null;
            }
            user = new User(rs.getString("email"), rs.getString("name"), rs.getString("lastname"),
                    rs.getString("licenseNumber"), rs.getString("password"));
            rs.close();
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            }catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        return user;
    }
}
