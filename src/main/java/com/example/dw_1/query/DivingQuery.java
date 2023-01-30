package com.example.dw_1.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DivingQuery {
    public static ResultSet loadAllDiving (Statement stmt, Integer divingID) throws SQLException {
        String query = String.format("SELECT * FORM Diving WHERE divingManager = '%d';",divingID );
        return stmt.executeQuery(query);
    }
    public static ResultSet loadAllDivingByManager(Statement stmt, String managerID) throws SQLException {
        String query = String.format("SELECT * FORM Diving WHERE divingManager = '%s';",managerID );
        return stmt.executeQuery(query);
    }
    public static ResultSet selectDivingByName(Statement stmt, String divingName) throws SQLException {
        String query = String.format("SELECT * FROM Diving WHERE name = '%s';", divingName);
        return stmt.executeQuery(query);
    }
    public static ResultSet selectDivingByLocation(Statement stmt, String location) throws SQLException {
        String query = String.format("SELECT * FROM Diving WHERE location = '%s';", location);
        return stmt.executeQuery(query);
    }
    public static ResultSet loadDivingByName (Statement stmt, String location) throws SQLException {
        String query = String.format("SELECT * FORM Diving WHERE divingManager = '%s';",location );
        return stmt.executeQuery(query);
    }

}
