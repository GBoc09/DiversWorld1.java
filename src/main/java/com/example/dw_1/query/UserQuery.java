package com.example.dw_1.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserQuery extends Query {
    public static ResultSet selectUserByCredentials(Statement stmt, String email, String password) throws SQLException {
        String query = String.format("SELECT * FROM User WHERE email = '%s' AND password = '%s';", email,password);
        return stmt.executeQuery(query);
    }
    public static boolean insertUser(Statement stmt, String email, String password, String type) throws SQLException{
        System.out.println("user query: INSERT USER");
        System.out.println(email);
        System.out.println(password);

        String query = String.format("INSERT INTO User values('%s', '%s', '%s');", email, password, type);
        return stmt.execute(query);
    }

    public static boolean insertIntoScuba(Statement stmt, String license,String name, String lastname) throws SQLException{
        System.out.println("user query: INSERT INTO SCUBA");
        System.out.println(name);
        System.out.println(lastname);
        System.out.println(license);
        String query = String.format("INSERT INTO Scuba values('%s', '%s', '%s');",license, name, lastname);
        return stmt.execute(query);
    }
    public static boolean insertIntoFree(Statement stmt, String name, String lastname, String license ) throws SQLException{
        String query = String.format("INSERT INTO Free values('%s', '%s', '%s');", license, name, lastname);
        return stmt.execute(query);
    }
    public static boolean insertIntoManager(Statement stmt, String name, String lastname, String idManager) throws SQLException{
        System.out.println("user query: INSERT INTO MANAGER");
        System.out.println(name);
        System.out.println(lastname);
        System.out.println(idManager);
        String query = String.format("INSERT INTO DivingManager values('%s','%s', '%s');", idManager, name, lastname);
        return stmt.execute(query);
    }
    public static boolean deleteManager(Statement stmt, String name, String lastname, String idManager) throws SQLException{
        System.out.println("user query: DELETE MANAGER");
        System.out.println(name);
        System.out.println(lastname);
        System.out.println(idManager);
        String query = String.format("DELETE FROM DivingManager WHERE idDivingManager = '%s';", idManager);
        return stmt.execute(query);
    }
    public static boolean deleteScuba(Statement stmt, String name, String lastname, String license) throws SQLException{
        System.out.println("user query: DELETE MANAGER");
        System.out.println(name);
        System.out.println(lastname);
        System.out.println(license);
        String query = String.format("DELETE FROM DivingManager WHERE licenseNumber = '%s';", license);
        return stmt.execute(query);
    }


}
