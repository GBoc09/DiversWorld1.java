package com.example.dw_1.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserQuery extends Query {
    public static ResultSet selectUserByCredentials(Statement stmt, String email, String password) throws SQLException {
        String query = String.format("SELECT * FROM User WHERE email = '%s' AND password = '%s';", email,password);
        return stmt.executeQuery(query);
    }
    public static ResultSet selectUserByEmail(Statement stmt, String email) throws SQLException {
        String query = String.format("SELECT * FROM User WHERE email = '%s' ;", email);
        return stmt.executeQuery(query);
    }
    public static ResultSet selectScubaByEmail(Statement statement, String email) throws SQLException {
        String query = String.format("SELECT * FROM Scuba WHERE userEmail = '%s';", email);
        return statement.executeQuery(query);
    }

    public static boolean insertUser(Statement stmt, String email, String password, String type) throws SQLException{
        String query = String.format("INSERT INTO User values('%s', '%s', '%s');", email, password, type);
        return stmt.execute(query);
    }
    public static boolean selectUser(Statement stmt, String email) throws SQLException{
        String query = String.format("SELECT * FROM User WHERE email = '%s'; ", email);
        return stmt.execute(query);
    }

    public static boolean insertIntoScuba(Statement stmt, String license,String name, String lastname) throws SQLException{
        String query = String.format("INSERT INTO Scuba values('%s', '%s', '%s');",license, name, lastname);
        return stmt.execute(query);
    }
    public static boolean selectScuba(Statement stmt, String license) throws SQLException{
        String query = String.format("SELECT * FROM Scuba WHERE licenseNumber = '%s'; ", license);
        return stmt.execute(query);
    }
    public static boolean insertIntoFree(Statement stmt, String name, String lastname, String license ) throws SQLException{
        String query = String.format("INSERT INTO Free values('%s', '%s', '%s');", license, name, lastname);
        return stmt.execute(query);
    }
    public static boolean insertIntoManager(Statement stmt, String name, String lastname, String idManager) throws SQLException{
        String query = String.format("INSERT INTO DivingManager values('%s','%s', '%s');", idManager, name, lastname);
        return stmt.execute(query);
    }
    public static ResultSet selectManager(Statement statement, String managerID) throws SQLException {
        String query = String.format("SELECT * FROM DivingManager WHERE idDivingManager = '%s';", managerID);
        return statement.executeQuery(query);
    }

    public static boolean deleteManager(Statement stmt, String name, String lastname, String idManager) throws SQLException{
        String query = String.format("DELETE FROM DivingManager WHERE idDivingManager = '%s';", idManager);
        return stmt.execute(query);
    }
    public static boolean deleteScuba(Statement stmt, String name, String lastname, String license) throws SQLException{
        String query = String.format("DELETE FROM DivingManager WHERE licenseNumber = '%s';", license);
        return stmt.execute(query);
    }


}
