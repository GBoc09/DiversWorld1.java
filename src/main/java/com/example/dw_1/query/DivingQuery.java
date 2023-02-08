package com.example.dw_1.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DivingQuery {
    public static boolean insertDiving(Statement stmt, String id, String name, String manager, String loc, String tel) throws SQLException{
        String query = String.format("INSERT INTO Diving values('%s', '%s', '%s', '%s', '%s');", id, name, manager, loc,tel);
        return stmt.execute(query);
    }
    public static ResultSet selectDivingByName(Statement stmt, String divingName) throws SQLException {
        String query = String.format("SELECT * FROM Diving WHERE name = '%s';", divingName);
        return stmt.executeQuery(query);
    }
    public static ResultSet selectDiving(Statement stmt) throws SQLException {
        String query = String.format("SELECT * FROM Diving;");
        return stmt.executeQuery(query);
    }

}
