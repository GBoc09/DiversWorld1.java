package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.Scuba;
import com.example.dw_1.entity.User;
import com.example.dw_1.exception.AlreadyRegisteredUserException;
import com.example.dw_1.query.UserQuery;

import java.sql.*;

public class ScubaDAO {
    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();

    private static final String SCUBA = "scuba";
    private static final String SCUBA_EMAIL = "emailUser";
    private static final String SCUBA_NAME = "name";
    private static final String SCUBA_LASTNAME = "lastname";
    private static final Integer SCUBA_LICENSE = 00000000;

    public void insertScuba(User scuba) throws AlreadyRegisteredUserException{
        Connection con =connection.getConnection();
        try(Statement stmt = con.createStatement();){
            UserQuery.insertUser(stmt, scuba.getEmail(), scuba.getPassword(), SCUBA);
            UserQuery.insertIntoScuba(stmt, scuba.getName(), scuba.getLastname(), scuba.getEmail(), scuba.getLicense());
        } catch (SQLIntegrityConstraintViolationException e){
            throw new AlreadyRegisteredUserException(1);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
    public Scuba createScuba(ResultSet rs) throws SQLException {
        String email = rs.getString(SCUBA_EMAIL);
        String name = rs.getString(SCUBA_NAME);
        String lastname = rs.getString(SCUBA_LASTNAME);
        Integer license = rs.getInt(SCUBA_LICENSE);

        return new Scuba(email,"", name, lastname, license);
    }
}
