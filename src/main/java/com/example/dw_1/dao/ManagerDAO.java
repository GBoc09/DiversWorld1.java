package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.Manager;
import com.example.dw_1.entity.User;
import com.example.dw_1.exception.AlreadyRegisteredUserException;
import com.example.dw_1.query.UserQuery;

import java.sql.*;

public class ManagerDAO {
    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();

    private static final String MANAGER = "manager";
    private static final String MANAGER_EMAIL = "emailUser";
    private static final String MANAGER_NAME = "name";
    private static final String MANAGER_LASTNAME = "lastname";
    private static final String MANAGER_ID = "";
    public void insertManager(User manager) throws AlreadyRegisteredUserException {
        Connection con =connection.getConnection();
        try(Statement stmt = con.createStatement();){
            System.out.println("manager dao: INSERT MANAGER");
            UserQuery.insertUser(stmt, manager.getEmail(), manager.getPassword(), MANAGER);
            UserQuery.insertIntoManager(stmt, manager.getName(), manager.getLastname(), manager.getLicense());
        } catch (SQLIntegrityConstraintViolationException e){
            throw new AlreadyRegisteredUserException(1);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
    public Manager createManager(ResultSet rs) throws SQLException {
        String email = rs.getString(MANAGER_EMAIL);
        String name = rs.getString(MANAGER_NAME);
        String lastname = rs.getString(MANAGER_LASTNAME);
        String license = rs.getString(MANAGER_ID);

        return new Manager(email,"", name, lastname, license);
    }
}
