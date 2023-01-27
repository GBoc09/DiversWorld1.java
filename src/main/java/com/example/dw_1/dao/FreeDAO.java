package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.Free;
import com.example.dw_1.entity.User;
import com.example.dw_1.exception.AlreadyRegisteredUserException;
import com.example.dw_1.query.UserQuery;

import java.sql.*;

public class FreeDAO {
    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();

    private static final String FREE = "free";
    private static final String FREE_EMAIL = "emailUser";
    private static final String FREE_NAME = "name";
    private static final String FREE_LASTNAME = "lastname";
    private static final String FREE_LICENSE = "";

    public void insertFree(User free) throws AlreadyRegisteredUserException {
        Connection con =connection.getConnection();
        try(Statement stmt = con.createStatement();){
            UserQuery.insertUser(stmt, free.getEmail(), free.getPassword(), FREE);
            UserQuery.insertIntoFree(stmt, free.getName(), free.getLastname(),free.getLicense());
        } catch (SQLIntegrityConstraintViolationException e){
            throw new AlreadyRegisteredUserException(1);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
    public Free createFree(ResultSet rs) throws SQLException {
        String email = rs.getString(FREE_EMAIL);
        String name = rs.getString(FREE_NAME);
        String lastname = rs.getString(FREE_LASTNAME);
        String license = rs.getString(FREE_LICENSE);

        return new Free(email,"", name, lastname, license);
    }
}
