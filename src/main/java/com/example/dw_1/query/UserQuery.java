package com.example.dw_1.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserQuery extends Query {
    public static ResultSet selectUserByCredentials(Statement stmt, String email, String password) throws SQLException {
        String query = String.format("SELECT * FROM user WHERE email = %s AND password = '%s';", email,password);
        return stmt.executeQuery(query);
    }
    public static boolean insertUser(Statement stmt, String email, String password, String type) throws SQLException{
        String query = String.format("INSERT INTO user values('%s', '%s', '%s');", email, password, type);
        return stmt.execute(query);
    }

    public static boolean insertIntoScuba(Statement stmt, String name, String lastname, String email, Integer license ) throws SQLException{
        String query = String.format("INSERT INTO scuba values('%s', '%s', '%s', '%d');", name, lastname, email, license);
        return stmt.execute(query);
    }
    public static boolean insertIntoFree(Statement stmt, String name, String lastname, String email, Integer license ) throws SQLException{
        String query = String.format("INSERT INTO free values('%s', '%s', '%s', '%d');", name, lastname, email, license);
        return stmt.execute(query);
    }
    public static boolean insertIntoManager(Statement stmt, String name, String lastname, String email) throws SQLException{
        String query = String.format("INSERT INTO divingmanager values('%s', '%s', '%s');", name, lastname, email);
        return stmt.execute(query);
    }


}
