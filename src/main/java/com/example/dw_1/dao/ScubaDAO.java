package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.Scuba;
import com.example.dw_1.entity.User;
import com.example.dw_1.exception.AlreadyRegisteredUserException;
import com.example.dw_1.exception.NotExistantException;
import com.example.dw_1.query.UserQuery;

import java.sql.*;

public class ScubaDAO {
    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();

    private static final String SCUBA = "scuba";
    private static final String SCUBA_EMAIL = "emailUser";
    private static final String SCUBA_PASS = "pass";
    private static final String SCUBA_NAME = "name";
    private static final String SCUBA_LASTNAME = "lastname";
    private static final String SCUBA_LICENSE = "";

    public void insertScuba(User scuba) throws AlreadyRegisteredUserException{
        Connection con =connection.getConnection();
        try(Statement stmt = con.createStatement();){
            UserQuery.insertUser(stmt, scuba.getEmail(), scuba.getPassword(), SCUBA);
            UserQuery.insertIntoScuba(stmt, scuba.getLicense(),scuba.getName(), scuba.getLastname(), scuba.getEmail());
        } catch (SQLIntegrityConstraintViolationException e){
            throw new AlreadyRegisteredUserException(1);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
   public Scuba retrieveInfoScuba (String userEmail){
        Scuba scuba = null;
        Connection con = connection.getConnection();
        try (Statement stmt = con.createStatement();
        ResultSet rs = UserQuery.selectScubaByEmail(stmt, userEmail)){
            while (rs.next()) {
                scuba = createScuba(rs);
            }
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return scuba;
   }
   public Scuba loadScubaByEmail(String userEmail) throws NotExistantException {
        Scuba scuba  = retrieveInfoScuba(userEmail);
        if (scuba == null){
            throw new NotExistantException("Email not found");
        }
        return scuba;
   }
    public Scuba createScuba(ResultSet rs) throws SQLException {
        String email = rs.getString(SCUBA_EMAIL);
        String pass = rs.getString(SCUBA_PASS);
        String name = rs.getString(SCUBA_NAME);
        String lastname = rs.getString(SCUBA_LASTNAME);
        String license = rs.getString(SCUBA_LICENSE);

        return new Scuba(email, pass, name, lastname, license);
    }
}
